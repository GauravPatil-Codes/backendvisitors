package com.minister.visitorsapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minister.visitorsapp.entities.Departments;
import com.minister.visitorsapp.repos.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Departments CreateDepartments(Departments departments) {
        return departmentRepository.save(departments);
    }

    @Override
    public List<Departments> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Departments showById(String id) {
        return departmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Department not found"));
    }
    
    @Override
    public Departments updateDepartment(String id, Departments updatedDepartment) {
        Departments existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
        existingDepartment.setDepartmentemail(updatedDepartment.getDepartmentemail());

        return departmentRepository.save(existingDepartment);
    }

    @Override
    public Departments deleteDepartment(String id) {
        Departments existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        departmentRepository.delete(existingDepartment);
        return existingDepartment;
    }

}
