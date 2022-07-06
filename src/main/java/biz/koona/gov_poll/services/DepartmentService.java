package biz.koona.gov_poll.services;

import biz.koona.gov_poll.entities.Department;
import biz.koona.gov_poll.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createUpdate(Department department) {
        return departmentRepository.save(department);
    }

    public Department readOne(String id) {
        return departmentRepository.findById(id).get();
    }

    public Iterable<Department> readAll() {
        return departmentRepository.findAll();
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
