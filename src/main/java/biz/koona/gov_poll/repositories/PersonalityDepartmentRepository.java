package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Department;
import biz.koona.gov_poll.entities.PersonalityDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalityDepartmentRepository extends CrudRepository<PersonalityDepartment, String> {
    PersonalityDepartment findByDepartment(Department department);
}