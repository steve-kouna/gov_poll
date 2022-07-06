package biz.koona.gov_poll.dtos;

public class DepartmentDto {
    private String id;
    private String title;
    private String description;

    public DepartmentDto() {
    }

    public DepartmentDto(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
