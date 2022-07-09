package biz.koona.gov_poll.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonalityForm {
    private String headId;
    @NotNull
    @NotBlank
    private String firtname;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    private String biography;

    public PersonalityForm() {
    }

    public PersonalityForm(String headId, String firtname, String lastname, String biography) {
        this.headId = headId;
        this.firtname = firtname;
        this.lastname = lastname;
        this.biography = biography;
    }

    public String getHeadId() {
        return headId;
    }

    public String getFirtname() {
        return firtname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBiography() {
        return biography;
    }
}
