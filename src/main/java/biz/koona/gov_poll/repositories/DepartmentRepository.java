package biz.koona.gov_poll.repositories;

import biz.koona.gov_poll.entities.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, String> {
}