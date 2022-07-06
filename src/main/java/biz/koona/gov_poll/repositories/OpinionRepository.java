package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Opinion;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, String> {
}