package biz.koona.gov_poll.dtos;

public class PersonalityDto {
    private String id;
    private String firtname;
    private String lastname;
    private String biography;

    public PersonalityDto() {
    }

    public PersonalityDto(String id, String firtname, String lastname, String biography) {
        this.id = id;
        this.firtname = firtname;
        this.lastname = lastname;
        this.biography = biography;
    }

    public String getId() {
        return id;
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
