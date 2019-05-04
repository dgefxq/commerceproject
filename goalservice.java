package sample9.demo9;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class goalservice {

  @Autowired
  goalrepo goalrepo;

  @Autowired
  userrepo userrepo;

  maincontroller maincontroller = new maincontroller();
  userdata userdata = new userdata();

  // userdata currentUser = getCurrentUser();

  public userdata getCurrentUser() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return userrepo.findByUsername(auth.getName());
  }

  public List<goaldata> findAll() {
    int userid = getCurrentUser().getId();
    return goalrepo.findAll(userid);
  }

  public List<goaldata> currentGoals() {
    int userid = getCurrentUser().getId();
    return goalrepo.findCurrentGoals(userid);
  }

  public int uniquerewardindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.uniquerewardindex(userid);
  }

  public goaldata findOne(Integer id) {
    return goalrepo.findById(id).get();
  }

  public goaldata changerewardstatus(goaldata goaldata) {

    goaldata.setGoalstatus("rewarded");
    return goalrepo.save(goaldata);
  }

  public goaldata savegoal(goaldata goaldata) {
    goaldata.setUserid(getCurrentUser());
    goaldata.setGoalstatus("processing");
    return goalrepo.save(goaldata);
  }

  public goaldata savegoaladmin(goaldata goaldata) {

    goaldata.setGoalstatus("processing");
    return goalrepo.save(goaldata);
  }

  public List<Integer> goalrewardindex() {
    return goalrepo.goalrewardindex();
  }

  public List<Integer> goalrewarduserindex() {
    return goalrepo.goalrewarduserindex();
  }

  public goaldata achievedupdate(goaldata goaldata) {

    goaldata.setGoalstatus("achieved");
    return goalrepo.save(goaldata);
  }

  public goaldata missedupdate(goaldata goaldata) {

    goaldata.setGoalstatus("missed");
    return goalrepo.save(goaldata);
  }

  public void deletegoal(goaldata goaldata) {
    goalrepo.delete(goaldata);
  }

  public Double goalreward() {
    int userid = getCurrentUser().getId();
    return goalrepo.goalreward(userid);
  }

  public String goalrewardstatus() {
    int userid = getCurrentUser().getId();
    return goalrepo.goalrewardstatus(userid);
  }

  public int countall() {
    int userid = getCurrentUser().getId();
    return goalrepo.countall(userid);
  }

  public int countcurrent() {
    int userid = getCurrentUser().getId();
    return goalrepo.countcurrent(userid);
  }

  public int countachieved() {
    int userid = getCurrentUser().getId();
    return goalrepo.countachieved(userid);
  }

  public int countmissed() {
    int userid = getCurrentUser().getId();
    return goalrepo.countmissed(userid);
  }

  public List<Double> setGoalamount() {
    int userid = getCurrentUser().getId();
    return goalrepo.goalamount(userid);
  }

  public List<String> setFindgoaltype() {
    int userid = getCurrentUser().getId();
    return goalrepo.findgoaltype(userid);
  }

  public List<String> setFindaccounttype() {
    int userid = getCurrentUser().getId();
    return goalrepo.findaccounttype(userid);
  }

  public List<Date> findduedate() {
    int userid = getCurrentUser().getId();
    return goalrepo.findduedate(userid);
  }

  public List<Date> findcreatedate() {
    int userid = getCurrentUser().getId();
    return goalrepo.findcreatedate(userid);
  }

  public List<String> findgoalstatus() {
    int userid = getCurrentUser().getId();
    return goalrepo.findgoalstatus(userid);
  }

  public List<String> allgoaltitle() {
    int userid = getCurrentUser().getId();
    return goalrepo.allgoaltitle(userid);
  }

  public List<String> allgoalnote() {
    int userid = getCurrentUser().getId();
    return goalrepo.allgoalnote(userid);
  }

  public List<Date> allcreatedate() {
    int userid = getCurrentUser().getId();
    return goalrepo.allcreatedate(userid);
  }

  public List<Double> withdrawlaltemp() {
    int userid = getCurrentUser().getId();
    return goalrepo.withdrawlaltemp(userid);
  }

  public List<Integer> drindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.drindex(userid);
  }

  public List<Double> deposittemp() {
    int userid = getCurrentUser().getId();
    return goalrepo.deposittemp(userid);
  }

  public List<Integer> crindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.crindex(userid);
  }

  public List<Double> beginbalancetemp() {
    int userid = getCurrentUser().getId();
    return goalrepo.beginbalancetemp(userid);
  }

  public List<Double> crbalancetemp() {
    int userid = getCurrentUser().getId();
    return goalrepo.crbalancetemp(userid);
  }

  public List<Double> drbalancetemp() {
    int userid = getCurrentUser().getId();
    return goalrepo.drbalancetemp(userid);
  }

  public List<Integer> beginbalanceindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.beginbalanceindex(userid);
  }

  public List<Integer> crbalanceindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.crbalanceindex(userid);
  }

  public List<Integer> drbalanceindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.drbalanceindex(userid);
  }

  public List<Integer> allindex() {
    int userid = getCurrentUser().getId();
    return goalrepo.allindex(userid);
  }

  public List<Double> drlist() {
    int userid = getCurrentUser().getId();
    return goalrepo.drlist(userid);
  }

  public List<Double> crlist() {
    int userid = getCurrentUser().getId();
    return goalrepo.crlist(userid);
  }

  public List<Date> drdate() {
    int userid = getCurrentUser().getId();
    return goalrepo.drdate(userid);
  }

  public List<Date> crdate() {
    int userid = getCurrentUser().getId();
    return goalrepo.crdate(userid);
  }

}