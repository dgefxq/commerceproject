package sample9.demo9;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userrepo extends JpaRepository<userdata, Integer> {

    List<userdata> findAll();

    userdata findByUsername(String username);

}
