package biz.koona.gov_poll.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "personality")
public class Personality {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false, length = 45)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personality_id")
    private Personality personality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id")
    private FileCabinet picture;

    @Column(name = "firtname", nullable = false, length = 45)
    private String firtname;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Lob
    @Column(name = "biography")
    private String biography;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "personality")
    private Set<Personality> personalities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "personality")
    private Set<PersonalityDepartment> personalityDepartments = new LinkedHashSet<>();

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

    public Personality() {
    }

    public Personality(Personality personality, FileCabinet picture, String firtname, String lastname, String biography) {
        this.personality = personality;
        this.picture = picture;
        this.firtname = firtname;
        this.lastname = lastname;
        this.biography = biography;
    }

    public Set<PersonalityDepartment> getPersonalityDepartments() {
        return personalityDepartments;
    }

    public void setPersonalityDepartments(Set<PersonalityDepartment> personalityDepartments) {
        this.personalityDepartments = personalityDepartments;
    }

    public Set<Personality> getPersonalities() {
        return personalities;
    }

    public void setPersonalities(Set<Personality> personalities) {
        this.personalities = personalities;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirtname() {
        return firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public FileCabinet getPicture() {
        return picture;
    }

    public void setPicture(FileCabinet picture) {
        this.picture = picture;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}