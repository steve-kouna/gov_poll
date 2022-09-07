package biz.koona.gov_poll.dtos;

public class PersonalityDepartmentDto {
    private String id;
    private PersonalityDto personalityDto;
    private DepartmentDto departmentDto;
    private UploadFileResponse image;

    public PersonalityDepartmentDto(String id, PersonalityDto personalityDto, DepartmentDto departmentDto, UploadFileResponse image) {
        this.id = id;
        this.personalityDto = personalityDto;
        this.departmentDto = departmentDto;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonalityDto getPersonalityDto() {
        return personalityDto;
    }

    public void setPersonalityDto(PersonalityDto personalityDto) {
        this.personalityDto = personalityDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }

    public UploadFileResponse getImage() {
        return image;
    }

    public void setImage(UploadFileResponse image) {
        this.image = image;
    }
}
