package sample9.demo9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class transactionservice {

  @Autowired
  transactionrepo transactionrepo;

  @Autowired
  userrepo userrepo;

  @Autowired
  goalservice goalservice;

  goaldata goaldata = new goaldata();

  public userdata getCurrentUser() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    return userrepo.findByUsername(auth.getName());
  }

  public List<transactiondata> findAll() {
    return transactionrepo.findAll();
  }

  public transactiondata findOne(Integer id) {
    return transactionrepo.findById(id).get();
  }

  public transactiondata savetransaction(transactiondata transactiondata) {

    // transactiondata.setUserid(getCurrentUser());

    if (transactiondata.getAccounttype().contentEquals("Checking"))
      transactiondata.setAccountnumber("211111110");

    if (transactiondata.getAccounttype().contentEquals("Savings"))
      transactiondata.setAccountnumber("3011111130");

    if (transactiondata.getAccounttype().contentEquals("Credit Card"))
      transactiondata.setAccountnumber("3111 3450 2930 9203");

    return transactionrepo.save(transactiondata);
  }

  public void deletetransaction(transactiondata transactiondata) {
    transactionrepo.delete(transactiondata);
  }

  public transactiondata savereward(transactiondata transactiondata) {

    transactiondata.setDescription("Earned Reward");
    transactiondata.setAmount(goalservice.goalreward());
    transactiondata.setUserid(getCurrentUser());
    transactiondata.setAccounttype("Checking");

    return transactionrepo.save(transactiondata);
  }

  public List<transactiondata> detailtransaction() {
    int userid = getCurrentUser().getId();
    return transactionrepo.detailtransaction(userid);
  }

}