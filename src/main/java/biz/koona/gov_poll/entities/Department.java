package biz.koona.gov_poll.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false, length = 45)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "title", length = 45)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public Department() {
    }

    public Department(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Department(Department department, String title, String description) {
        this.department = department;
        this.title = title;
        this.description = description;
    }

    @PrePersist
    private void postPersist(){
        Instant dateTime = Instant.now();
        this.createdAt = dateTime;
    }

    @PreUpdate
    private void postUpdate() {
        Instant dateTime = Instant.now();
        this.updatedAt = dateTime;
    }


    @OneToMany(mappedBy = "department")
    private Set<PersonalityDepartment> personalityDepartments = new LinkedHashSet<>();

    public Set<PersonalityDepartment> getPersonalityDepartments() {
        return personalityDepartments;
    }

    public void setPersonalityDepartments(Set<PersonalityDepartment> personalityDepartments) {
        this.personalityDepartments = personalityDepartments;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}