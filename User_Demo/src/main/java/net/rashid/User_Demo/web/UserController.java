package net.rashid.User_Demo.web;

import net.rashid.User_Demo.entities.User;
import net.rashid.User_Demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user = userService.findUserByUsername(username);
        return user;
    }
}
