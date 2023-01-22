package biz.koona.gov_poll.services;

import biz.koona.gov_poll.entities.Department;
import biz.koona.gov_poll.entities.PersonalityDepartment;
import biz.koona.gov_poll.repositories.PersonalityDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalityDepartmentService {
    @Autowired
    private PersonalityDepartmentRepository personalityDepartmentRepository;

    public PersonalityDepartment createUpdate(PersonalityDepartment personalityDepartment) {
        return personalityDepartmentRepository.save(personalityDepartment);
    }

    public PersonalityDepartment readOne(String id) {
        return personalityDepartmentRepository.findById(id).get();
    }

    public Iterable<PersonalityDepartment> readAll() {
        return personalityDepartmentRepository.findAll();
    }

    public PersonalityDepartment readByDepartment(Department department) {
        return personalityDepartmentRepository.findByDepartment(department);
    }
}
