package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.entities.Personality;
import biz.koona.gov_poll.forms.PersonalityForm;
import biz.koona.gov_poll.services.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalityController {
    @Autowired
    private PersonalityService personalityService;

    public Personality postPersonalty(@Validated @RequestBody PersonalityForm personalityForm) {
        Personality personality = new Personality();

        return personality;
    }
}
