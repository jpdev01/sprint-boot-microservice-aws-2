package core;

import core.entity.User;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixDatabase {

    @Autowired
    private UserService userService;

    public boolean run() {
        try {
            User user = new User();
            user.setLogin("teste");
            user.setPassword("123");
            user.setFullname("Teste criado a partir de script");
            userService.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
