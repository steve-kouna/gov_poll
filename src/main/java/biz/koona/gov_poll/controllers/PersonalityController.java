package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.dtos.PersonalityDto;
import biz.koona.gov_poll.dtos.UploadFileResponse;
import biz.koona.gov_poll.entities.FileCabinet;
import biz.koona.gov_poll.entities.Personality;
import biz.koona.gov_poll.forms.PersonalityForm;
import biz.koona.gov_poll.services.FileCabinetService;
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

    @PutMapping
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

}
