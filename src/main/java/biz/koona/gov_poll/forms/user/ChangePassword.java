package biz.koona.gov_poll.forms.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePassword {
    @NotNull
    @NotBlank
    private String oldPassword;

    @NotNull
    @NotBlank
    private String newPassword;

    public ChangePassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
