package biz.koona.gov_poll.dtos;

public class PersonalityDto {
    private String id;
    private String firstname;
    private String lastname;
    private String biography;

    public PersonalityDto(String id, String firstname, String lastname, String biography) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.biography = biography;
    }

    public String getId() {
        return id;
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
