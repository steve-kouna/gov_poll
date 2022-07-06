package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.PersonalityDepartment;
import org.springframework.data.repository.CrudRepository;

public interface PersonalityDepartmentRepository extends CrudRepository<PersonalityDepartment, String> {
}