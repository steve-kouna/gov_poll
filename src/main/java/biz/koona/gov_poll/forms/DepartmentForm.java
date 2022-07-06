package biz.koona.gov_poll.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DepartmentForm {
    @NotNull
    @NotBlank
    private String title;
    @NotBlank
    @NotNull
    private String description;

    public DepartmentForm() {
    }

    public DepartmentForm(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
