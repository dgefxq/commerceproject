package sample9.demo9;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface goalrepo extends JpaRepository<goaldata, Integer> {

  @Query(value = "SELECT * FROM goals WHERE userid=:userid", nativeQuery = true)
  List<goaldata> findAll(@Param("userid") int userid);

  @Query(value = "Select * FROM goals WHERE userid=:userid AND goalstatus LIKE 'pro%'", nativeQuery = true)
  List<goaldata> findCurrentGoals(@Param("userid") int userid);

  @Query(value = "SELECT goalamount FROM goals WHERE userid=:userid", nativeQuery = true)
  List<Double> goalamount(@Param("userid") int userid);

  @Query(value = "SELECT goaltype FROM goals g WHERE userid=:userid", nativeQuery = true)
  List<String> findgoaltype(@Param("userid") int userid);

  @Query(value = "SELECT accounttype FROM goals g WHERE userid=:userid", nativeQuery = true)
  List<String> findaccounttype(@Param("userid") int userid);

  @Query(value = "SELECT duedate FROM goals WHERE userid=:userid", nativeQuery = true)
  List<Date> findduedate(@Param("userid") int userid);

  @Query(value = "SELECT createddate FROM goals WHERE userid=:userid", nativeQuery = true)
  List<Date> findcreatedate(@Param("userid") int userid);

  @Query(value = "SELECT goalstatus FROM goals WHERE userid=:userid", nativeQuery = true)
  List<String> findgoalstatus(@Param("userid") int userid);

  @Query(value = "SELECT title FROM goals WHERE userid=:userid", nativeQuery = true)
  List<String> allgoaltitle(@Param("userid") int userid);

  @Query(value = "SELECT goalnote FROM goals WHERE userid=:userid", nativeQuery = true)
  List<String> allgoalnote(@Param("userid") int userid);

  @Query(value = "SELECT createddate FROM goals WHERE userid=:userid", nativeQuery = true)
  List<Date> allcreatedate(@Param("userid") int userid);

  @Query(value = "SELECT id FROM goals WHERE goalreward IS NOT NULL", nativeQuery = true)
  List<Integer> goalrewardindex();

  @Query(value = "SELECT userid FROM goals WHERE goalreward IS NOT NULL", nativeQuery = true)
  List<Integer> goalrewarduserindex();

  @Query(value = "SELECT SUM(round((goalreward), 2)) FROM goals WHERE userid=:userid", nativeQuery = true)
  Double goalreward(@Param("userid") int userid);

  @Query(value = "SELECT goalstatus FROM goals WHERE goalreward IS NOT NULL AND userid=:userid", nativeQuery = true)
  String goalrewardstatus(@Param("userid") int userid);

  @Query(value = "SELECT id FROM goals WHERE goalreward IS NOT NULL AND userid=:userid", nativeQuery = true)
  int uniquerewardindex(@Param("userid") int userid);

  @Query(value = "SELECT COALESCE(SUM(round((amount), 2)),0) FROM transaction u , goals g WHERE u.crdr='DR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.duedate AND u.processingdate > g.createddate GROUP BY g.id", nativeQuery = true)
  List<Double> withdrawlaltemp(@Param("userid") int userid);

  @Query(value = "SELECT g.id FROM transaction u , goals g WHERE u.crdr='DR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.duedate AND u.processingdate > g.createddate GROUP BY g.id", nativeQuery = true)
  List<Integer> drindex(@Param("userid") int userid);

  @Query(value = "SELECT COALESCE(SUM(round((amount), 2)),0) FROM transaction u , goals g WHERE u.crdr='CR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.duedate AND u.processingdate > g.createddate GROUP BY g.id", nativeQuery = true)
  List<Double> deposittemp(@Param("userid") int userid);

  @Query(value = "SELECT g.id FROM transaction u , goals g WHERE u.crdr='CR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.duedate AND u.processingdate > g.createddate GROUP BY g.id", nativeQuery = true)
  List<Integer> crindex(@Param("userid") int userid);

  @Query(value = "SELECT COALESCE(SUM(round((balance), 2)),0) FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.createddate GROUP BY g.id", nativeQuery = true)
  List<Double> beginbalancetemp(@Param("userid") int userid);

  @Query(value = "SELECT g.id FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.createddate GROUP BY g.id", nativeQuery = true)
  List<Integer> beginbalanceindex(@Param("userid") int userid);

  @Query(value = "SELECT COALESCE(SUM(round((amount), 2)),0) FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND crdr='CR' AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.createddate GROUP BY g.id", nativeQuery = true)
  List<Double> crbalancetemp(@Param("userid") int userid);

  @Query(value = "SELECT g.id FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND crdr='CR' AND u.processingdate < g.createddate GROUP BY g.id", nativeQuery = true)
  List<Integer> crbalanceindex(@Param("userid") int userid);

  @Query(value = "SELECT COALESCE(SUM(round((amount), 2)),0) FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND crdr='DR' AND u.userid=:userid AND g.userid=:userid AND u.processingdate < g.createddate GROUP BY g.id", nativeQuery = true)
  List<Double> drbalancetemp(@Param("userid") int userid);

  @Query(value = "SELECT g.id FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND crdr='DR' AND u.processingdate < g.createddate GROUP BY g.id", nativeQuery = true)
  List<Integer> drbalanceindex(@Param("userid") int userid);

  @Query(value = "SELECT id FROM goals WHERE userid=:userid GROUP BY id", nativeQuery = true)
  List<Integer> allindex(@Param("userid") int userid);

  @Query(value = "SELECT COUNT(id) FROM goals WHERE userid=:userid", nativeQuery = true)
  int countall(@Param("userid") int userid);

  @Query(value = "SELECT COUNT(id) FROM goals WHERE userid=:userid AND goalstatus='processing'", nativeQuery = true)
  int countcurrent(@Param("userid") int userid);

  @Query(value = "SELECT COUNT(id) FROM goals WHERE userid=:userid AND goalstatus='achieved'", nativeQuery = true)
  int countachieved(@Param("userid") int userid);

  @Query(value = "SELECT COUNT(id) FROM goals WHERE userid=:userid AND goalstatus='missed'", nativeQuery = true)
  int countmissed(@Param("userid") int userid);

  @Query(value = "SELECT amount FROM transaction u , goals g WHERE u.crdr='DR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND g.id='1' AND u.processingdate < g.duedate AND u.processingdate > g.createddate", nativeQuery = true)
  List<Double> drlist(@Param("userid") int userid);

  @Query(value = "SELECT amount FROM transaction u , goals g WHERE u.crdr='CR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND g.id='1' AND u.processingdate < g.duedate AND u.processingdate > g.createddate", nativeQuery = true)
  List<Double> crlist(@Param("userid") int userid);

  @Query(value = "SELECT processingdate FROM transaction u , goals g WHERE u.crdr='DR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND g.id='1' AND u.processingdate < g.duedate AND u.processingdate > g.createddate", nativeQuery = true)
  List<Date> drdate(@Param("userid") int userid);

  @Query(value = "SELECT processingdate FROM transaction u , goals g WHERE u.crdr='CR' AND u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND g.id='1' AND u.processingdate < g.duedate AND u.processingdate > g.createddate", nativeQuery = true)
  List<Date> crdate(@Param("userid") int userid);
}
