package biz.koona.gov_poll.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonalityForm {
    private String pictureId = null;
    private String headId = null;
    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    private String biography;

    public PersonalityForm() {
    }

    public PersonalityForm(String pictureId, String headId, String firstname, String lastname, String biography) {
        this.pictureId = pictureId;
        this.headId = headId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.biography = biography;
    }

    public String getPictureId() {
        return pictureId;
    }

    public String getHeadId() {
        return headId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBiography() {
        return biography;
    }
}
