package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.dtos.UserDto;
import biz.koona.gov_poll.entities.User;
import biz.koona.gov_poll.forms.user.RegisterForm;
import biz.koona.gov_poll.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/accounts")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public UserDto postUser(@Validated @RequestBody RegisterForm registerForm){
        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setUsername(registerForm.getUsername());
        user.setPassword(registerForm.getPassword());
        user = userService.createUpdate(user);

        UserDto userDto = new UserDto(user.getUsername(), user.getEmail());

        return userDto;
    }
}
