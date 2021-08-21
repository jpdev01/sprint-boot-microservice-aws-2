package main.security;

import core.entity.User;
import core.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = UserController.class)
class PortalUtilTest {

    //FIXME estudar https://dev.to/luizleite_/testes-realmente-unitarios-no-spring-boot-3gm8
    @Autowired
    private UserService userService;

    User getUser()
    {
        Optional<User> optionalUser = userService.get(01);
        if(optionalUser.isPresent())
        {
            return optionalUser.get();
        }
        return null;
    }

    void testLogin()
    {

    }

}
