package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Personality;
import org.springframework.data.repository.CrudRepository;

public interface PersonalityRepository extends CrudRepository<Personality, String> {
}