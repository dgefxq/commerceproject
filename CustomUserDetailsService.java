
package sample9.demo9;


import sample9.demo9.userdata;
import sample9.demo9.userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private userrepo userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        userdata user = userRepository.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), buildUserAuthority(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> buildUserAuthority(
            Collection<? extends GrantedAuthority> authorities) {
        return new HashSet<GrantedAuthority>();
    }



}
