package security.jwt;

import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        core.model.User user = findByLogin(login);
        if(user == null)
        {
            return null;
        }
        Integer userId = userService.validateLogin(login, user.getPassword());

//        if (user.getEmail().equals(email)) {
//            return new User(email, user.getPassword(),
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with email: " + email);
//        }
        //com.onroad.backend.entity.User user = userService.findById(userId).get();

        return new User(user.getLogin(), user.getPassword(),
                new ArrayList<>());
    }

    private core.model.User findByLogin(String login)
    {
        return userService.getUserByLogin(login);
    }
}


