package biz.koona.gov_poll.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

public class PersonalityDepartmentForm {
    @NotNull
    @NotBlank
    private Instant startedAt;
    private Instant finishIt;

    public Instant getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Instant startedAt) {
        this.startedAt = startedAt;
    }

    public Instant getFinishIt() {
        return finishIt;
    }

    public void setFinishIt(Instant finishIt) {
        this.finishIt = finishIt;
    }
}
