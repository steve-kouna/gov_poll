package biz.koona.gov_poll.dtos;

import biz.koona.gov_poll.entities.PersonalityDepartment;

import java.time.Instant;

public class OpinionDto {
    private PersonalityDepartmentDto personalityDepartment;
    private UserDto user;
    private Integer note;
    private String comment;
    private Instant from;
    private Instant to;
    private Instant createdAt;
    private Instant updatedAt;

    public OpinionDto(PersonalityDepartmentDto personalityDepartmentDto, UserDto userDto, Integer note, String comment, Instant from, Instant to, Instant createdAt, Instant updatedAt) {
        this.personalityDepartment = personalityDepartmentDto;
        this.user = userDto;
        this.note = note;
        this.comment = comment;
        this.from = from;
        this.to = to;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public PersonalityDepartmentDto getPersonalityDepartmentDto() {
        return personalityDepartment;
    }

    public void setPersonalityDepartmentDto(PersonalityDepartmentDto personalityDepartmentDto) {
        this.personalityDepartment = personalityDepartmentDto;
    }

    public UserDto getUserDto() {
        return user;
    }

    public void setUserDto(UserDto userDto) {
        this.user = userDto;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getFrom() {
        return from;
    }

    public void setFrom(Instant from) {
        this.from = from;
    }

    public Instant getTo() {
        return to;
    }

    public void setTo(Instant to) {
        this.to = to;
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
