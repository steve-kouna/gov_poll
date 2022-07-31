package biz.koona.gov_poll.services;

import biz.koona.gov_poll.entities.Opinion;
import biz.koona.gov_poll.repositories.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpinionService {
    @Autowired
    private OpinionRepository opinionRepository;

    public Opinion createUpdate(Opinion opinion) {
        return opinionRepository.save(opinion);
    }

    public Opinion readOne(String id) {
        return opinionRepository.findById(id).get();
    }

    public Iterable<Opinion> readAll() {
        return opinionRepository.findAll();
    }

    public void delete(Opinion opinion){
        opinionRepository.delete(opinion);
    }
}
