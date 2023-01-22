package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.forms.user.Login;
import biz.koona.gov_poll.services.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/authentication")
public class AuthenticateController {
//    @Autowired
//    private SecurityUserDetailsService userDetailsManager;

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        System.out.println(login.getUsername());
        return "User logged : " + login.getUsername();
    }
}
