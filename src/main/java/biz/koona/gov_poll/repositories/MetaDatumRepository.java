package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.MetaDatum;
import org.springframework.data.repository.CrudRepository;

public interface MetaDatumRepository extends CrudRepository<MetaDatum, String> {
}