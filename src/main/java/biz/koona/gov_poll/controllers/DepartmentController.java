package biz.koona.gov_poll.controllers;

import biz.koona.gov_poll.dtos.DepartmentDto;
import biz.koona.gov_poll.entities.Department;
import biz.koona.gov_poll.forms.DepartmentForm;
import biz.koona.gov_poll.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    @Transactional
    public DepartmentDto postDepartment(@Validated @RequestBody DepartmentForm departmentForm) {
        Department parent = departmentForm.getParentDepartmentId() != null ? departmentService.readOne(departmentForm.getParentDepartmentId()) : null;
        Department department = new Department(parent, departmentForm.getTitle(), departmentForm.getDescription());
        department = departmentService.createUpdate(department);

        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getTitle(), department.getDescription());

        return departmentDto;
    }

    @GetMapping
    @Transactional
    public List<DepartmentDto> getDepartments() {
        Iterable<Department> departments = departmentService.readAll();
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getTitle(), department.getDescription());
            departmentDtos.add(departmentDto);
        });

        return departmentDtos;
    }

    @GetMapping("/{id}")
    @Transactional
    public DepartmentDto getDepartment(@PathVariable("id") String id) {
        Department department = departmentService.readOne(id);
        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getTitle(), department.getDescription());
        return  departmentDto;
    }

    @GetMapping("/{id}/sub-departments")
    @Transactional
    public Iterable<DepartmentDto> getSubDepartments(@PathVariable("id") String id) {
        Department depart = departmentService.readOne(id);
        Iterable<Department> departments = departmentService.readSubDepartment(depart);
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        departments.forEach(department -> {
            DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getTitle(), department.getDescription());
            departmentDtos.add(departmentDto);
        });

        return  departmentDtos;
    }

    @PutMapping("/{id}")
    @Transactional
    public DepartmentDto putDepartment(@Validated @RequestBody DepartmentForm departmentForm, @PathVariable("id") String id) {
        Department department = departmentService.readOne(id);
        department.setTitle(departmentForm.getTitle());
        department.setDescription(departmentForm.getDescription());
        department = departmentService.createUpdate(department);
        DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getTitle(), department.getDescription());

        return departmentDto;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDepartment(@PathVariable("id") String id) {
        Department department = departmentService.readOne(id);
        departmentService.delete(department);
    }
}
