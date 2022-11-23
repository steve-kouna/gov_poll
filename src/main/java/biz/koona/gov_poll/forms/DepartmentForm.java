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

    private String parentDepartmentId = null;

    public DepartmentForm() {
    }

    public DepartmentForm(String title, String description, String parentDepartmentId) {
        this.title = title;
        this.description = description;
        this.parentDepartmentId = parentDepartmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getParentDepartmentId() {
        return parentDepartmentId;
    }
}
