package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.dtos.DepartmentDto;
import biz.koona.gov_poll.dtos.PersonalityDepartmentDto;
import biz.koona.gov_poll.dtos.PersonalityDto;
import biz.koona.gov_poll.dtos.UploadFileResponse;
import biz.koona.gov_poll.entities.Department;
import biz.koona.gov_poll.entities.FileCabinet;
import biz.koona.gov_poll.entities.Personality;
import biz.koona.gov_poll.entities.PersonalityDepartment;
import biz.koona.gov_poll.forms.PersonalityDepartmentForm;
import biz.koona.gov_poll.forms.PersonalityForm;
import biz.koona.gov_poll.services.DepartmentService;
import biz.koona.gov_poll.services.FileCabinetService;
import biz.koona.gov_poll.services.PersonalityDepartmentService;
import biz.koona.gov_poll.services.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/personalities")
public class PersonalityController {
    @Autowired
    private PersonalityService personalityService;
    @Autowired
    private FileCabinetService fileCabinetService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PersonalityDepartmentService personalityDepartmentService;

    @PostMapping
    @Transactional
    public PersonalityDto postPersonalty(@Validated @RequestBody PersonalityForm personalityForm) {
        FileCabinet picture = fileCabinetService.getFile(personalityForm.getPictureId());
        Personality headOfDepartment = personalityForm.getHeadId() != null? personalityService.readOne(personalityForm.getHeadId()):null;

        Personality personality = new Personality(headOfDepartment, picture, personalityForm.getFirtname(), personalityForm.getFirtname(), personalityForm.getBiography());
        personality = personalityService.createUpdate(personality);

        PersonalityDto personalityDto = new PersonalityDto(personality.getId(), personality.getFirtname(), personality.getLastname(), personality.getBiography());
        return personalityDto;
    }

    @GetMapping
    @Transactional
    public List<PersonalityDto> getPersonalities() {
        Iterable<Personality> personalities = personalityService.readAll();
        List<PersonalityDto> personalityDtos = new ArrayList<>();

        personalities.forEach(personality -> {
            PersonalityDto personalityDto = new PersonalityDto(personality.getId(), personality.getFirtname(), personality.getLastname(), personality.getBiography());
            personalityDtos.add(personalityDto);
        });
        return personalityDtos;
    }

    @PutMapping("/{id}")
    @Transactional
    public PersonalityDto putPersonality(@PathVariable("id") String id, @Validated @RequestBody PersonalityForm personalityForm) {
        Personality personality = personalityService.readOne(id);
        Personality parent = personalityService.readOne(personalityForm.getHeadId());
        personality.setPersonality(parent);
        personality.setBiography(personalityForm.getBiography());
        personality.setFirtname(personalityForm.getFirtname());
        personality.setLastname(personalityForm.getLastname());

        PersonalityDto personalityDto = new PersonalityDto(personality.getId(), personality.getFirtname(), personality.getLastname(), personality.getBiography());

        return personalityDto;
    }

    @PostMapping("/{persoId}/departments/{depId}")
    @Transactional
    public PersonalityDepartmentDto addPersonalityDepartment(@PathVariable("persoId") String persoId, @PathVariable("depId") String depId, PersonalityDepartmentForm form){
        PersonalityDepartment personalityDepartment = new PersonalityDepartment();
        Personality personality = personalityService.readOne(persoId);
        Department department = departmentService.readOne(depId);

        personalityDepartment.setDepartment(department);
        personalityDepartment.setPersonality(personality);
        personalityDepartment.setStartedAt(form.getStartedAt());
        personalityDepartment.setFinishIt(form.getFinishIt());

        personalityDepartment = personalityDepartmentService.createUpdate(personalityDepartment);

        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getTitle(), department.getDescription());
        PersonalityDto personalityDto = new PersonalityDto(personality.getId(), personality.getFirtname(), personality.getLastname(), personality.getBiography());
        UploadFileResponse image = new UploadFileResponse();

        PersonalityDepartmentDto personalityDepartmentDto = new PersonalityDepartmentDto(
                personalityDepartment.getId(),
                personalityDto,
                departmentDto,
                image
        );

        return personalityDepartmentDto;
    }
}
