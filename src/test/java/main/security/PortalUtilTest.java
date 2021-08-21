package main.security;

import core.controller.UserController;
import core.entity.User;
import core.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class PortalUtilTest {

    //FIXME estudar https://dev.to/luizleite_/testes-realmente-unitarios-no-spring-boot-3gm8
    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    User getUser()
    {
        Optional<User> optionalUser = userService.get(01);
        if(optionalUser.isPresent())
        {
            return optionalUser.get();
        }
        return null;
    }

    @Test
    void findAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        when(userService.getAll()).thenReturn(userList);
        this.mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(containsString("DOC12346")));
    }

}
