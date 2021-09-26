package core;

import core.entity.User;
import core.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixDatabase {

    @Autowired
    private UserService userService;

    public boolean run() {
        try {
            List<User> users = userService.getAll();
            if (users.isEmpty())
            {
                this.createAdmUser();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void createAdmUser()
    {
        User user = new User();
        user.setLogin("adm");
        user.setPassword("adm");
        user.setFullname("Administrador");
        userService.save(user);
    }
}
