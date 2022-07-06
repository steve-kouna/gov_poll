package biz.koona.gov_poll.services;

import biz.koona.gov_poll.entities.Personality;
import biz.koona.gov_poll.repositories.PersonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalityService {
    @Autowired
    private PersonalityRepository personalityRepository;

    public Personality createUpdate(Personality personality) {
        return personalityRepository.save(personality);
    }

    public Personality readOne(String id) {
        return personalityRepository.findById(id).get();
    }

    public Iterable<Personality> readAll() {
        return personalityRepository.findAll();
    }

    public void delete(Personality personality) {
        personalityRepository.delete(personality);
    }
}
