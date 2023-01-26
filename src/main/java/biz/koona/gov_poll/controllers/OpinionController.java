package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.dtos.*;
import biz.koona.gov_poll.entities.*;
import biz.koona.gov_poll.forms.OpinionForm;
import biz.koona.gov_poll.services.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/opinions")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;
    @Autowired
    private UserService userService;
    @Autowired
    private PersonalityDepartmentService personalityDepartmentService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    @Transactional
    public OpinionDto postOpinion(@Validated @RequestBody OpinionForm opinionForm) {
        User user = userService.readOne(opinionForm.getUserId());
        Department department = departmentService.readOne(opinionForm.getDepId());
        PersonalityDepartment personalityDepartment = personalityDepartmentService.readByDepartment(department);
        //Personality personality = ;
        Opinion opinion = new Opinion();

        opinion.setComment(opinionForm.getComment());
        opinion.setNote(opinionForm.getNote());
        opinion.setUser(user);
        opinion.setPersonalityDepartment(personalityDepartment);

        opinion = opinionService.createUpdate(opinion);

        UserDto userDto = new UserDto(user.getUsername(), user.getEmail());
        DepartmentDto departmentDto = new DepartmentDto(personalityDepartment.getDepartment().getId(), personalityDepartment.getDepartment().getTitle(), personalityDepartment.getDepartment().getDescription());
        PersonalityDto personalityDto = new PersonalityDto(personalityDepartment.getPersonality().getId(), personalityDepartment.getPersonality().getFirstname(), personalityDepartment.getPersonality().getLastname(), personalityDepartment.getPersonality().getBiography());
        //UploadFileResponse image = new UploadFileResponse();

        PersonalityDepartmentDto personalityDepartmentDto = new PersonalityDepartmentDto(personalityDepartment.getId(), personalityDto, departmentDto);

        OpinionDto opinionDto = new OpinionDto(personalityDepartmentDto, userDto, opinion.getNote(), opinion.getComment(),
                opinion.getFrom(), opinion.getTo(), opinion.getCreatedAt(), opinion.getUpdatedAt());

        return opinionDto;
    }

    @PutMapping("/{id}")
    @Transactional
    public OpinionDto putOpinion(@PathVariable("id") String id, @Validated @RequestBody OpinionForm opinionForm) {
        User user = userService.readOne(opinionForm.getUserId());
        Department department = departmentService.readOne(opinionForm.getDepId());
        PersonalityDepartment personalityDepartment = personalityDepartmentService.readByDepartment(department);

        Opinion opinion = opinionService.readOne(id);

        opinion.setComment(opinionForm.getComment());
        opinion.setNote(opinionForm.getNote());
        opinion.setUser(user);
        opinion.setPersonalityDepartment(personalityDepartment);

        opinion = opinionService.createUpdate(opinion);

        UserDto userDto = new UserDto(user.getUsername(), user.getEmail());
        DepartmentDto departmentDto = new DepartmentDto(personalityDepartment.getDepartment().getId(), personalityDepartment.getDepartment().getTitle(), personalityDepartment.getDepartment().getDescription());
        PersonalityDto personalityDto = new PersonalityDto(personalityDepartment.getPersonality().getId(), personalityDepartment.getPersonality().getFirstname(), personalityDepartment.getPersonality().getLastname(), personalityDepartment.getPersonality().getBiography());

        PersonalityDepartmentDto personalityDepartmentDto = new PersonalityDepartmentDto(personalityDepartment.getId(), personalityDto, departmentDto);

        OpinionDto opinionDto = new OpinionDto(personalityDepartmentDto, userDto, opinion.getNote(), opinion.getComment(),
                opinion.getFrom(), opinion.getTo(), opinion.getCreatedAt(), opinion.getUpdatedAt());

        return opinionDto;
    }
    @GetMapping
    public List<OpinionDto> getOpinions() {
        Iterable<Opinion> opinions = opinionService.readAll();
        List<OpinionDto> opinionDtos = new ArrayList<>();

        return opinionDtos;
    }
}
