package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Personality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalityRepository extends CrudRepository<Personality, String> {
}