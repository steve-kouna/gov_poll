package biz.koona.gov_poll.forms.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Login {
    @Email
    @NotBlank
    @NotNull
    private String username;
    @NotBlank
    @NotNull
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
