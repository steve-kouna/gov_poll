package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Opinion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends CrudRepository<Opinion, String> {
}