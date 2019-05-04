package sample9.demo9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface transactionrepo extends JpaRepository<transactiondata, Integer> {

  // @Query(value="SELECT * FROM transaction", nativeQuery = true)
  List<transactiondata> findAll();

  @Query(value = "SELECT * FROM transaction u , goals g WHERE u.accounttype=g.accounttype AND u.userid=:userid AND g.userid=:userid AND g.id='1' AND u.processingdate < g.duedate AND u.processingdate > g.createddate", nativeQuery = true)
  List<transactiondata> detailtransaction(@Param("userid") int userid);

}
