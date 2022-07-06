package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.FileCabinet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileCabinetRepository extends CrudRepository<FileCabinet, String> {
}