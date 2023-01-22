package biz.koona.gov_poll.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false, length = 45)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personality_department_id")
    private PersonalityDepartment personalityDepartment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "note", nullable = false)
    private Integer note;

    @Column(name = "comment", length = 45)
    private String comment;

    @Column(name = "available")
    private Integer available;

    @Column(name = "`from`")
    private Instant from;

    @Column(name = "`to`")
    private Instant to;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getTo() {
        return to;
    }

    public void setTo(Instant to) {
        this.to = to;
    }

    public Instant getFrom() {
        return from;
    }

    public void setFrom(Instant from) {
        this.from = from;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PersonalityDepartment getPersonalityDepartment() {
        return personalityDepartment;
    }

    public void setPersonalityDepartment(PersonalityDepartment personalityDepartment) {
        this.personalityDepartment = personalityDepartment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PrePersist
    private void postPersist() {
        Instant dateTime = Instant.now();
        this.createdAt = dateTime;
    }

    @PreUpdate
    private void postUpdate() {
        Instant dateTime = Instant.now();
        this.updatedAt = dateTime;
    }
}