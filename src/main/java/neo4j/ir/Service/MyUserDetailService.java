package neo4j.ir.Service;

import neo4j.ir.nodes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

/**
 * Created by Ali Asghar on 27/06/2017.
 */
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getUser(userName);
        if (user == null)
            return null;
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword()
                , Collections.singletonList((GrantedAuthority) () -> "ROLE_USER"));
    }
}