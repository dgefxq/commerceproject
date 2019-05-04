package sample9.demo9;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class userservice {

  @Autowired
  userrepo userrepo;

  public List<userdata> findAll() {
    return userrepo.findAll();
  }

  public userdata findOne(Integer id) {
    return userrepo.findById(id).get();
  }

  public userdata saveuser(userdata userdata) {

    return userrepo.save(userdata);
  }

  public userdata findByUsername(String username) {
    return userrepo.findByUsername(username);
  }

}