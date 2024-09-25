package com.minister.visitorsapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.minister.visitorsapp.entities.Departments;
import com.minister.visitorsapp.services.DepartmentServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class DepartmentsController {

    @Autowired
    DepartmentServiceImpl departmentServiceImpl;

    @PostMapping("/create/department")
    public ResponseEntity<Map<String, Object>> createDepartment(@RequestBody Departments departments) {
        Departments createdDepartment = departmentServiceImpl.CreateDepartments(departments);
        Map<String, Object> response = new HashMap<>();
        response.put("data", createdDepartment);
        response.put("status", HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listAll/departments")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllDepartments() {
        List<Departments> departmentsList = departmentServiceImpl.getAllDepartments();
        Map<String, Object> response = new HashMap<>();
        response.put("data", departmentsList);
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/department/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateDepartment(@PathVariable String id,
            @RequestBody Departments updatedDepartment) {
        Departments department = departmentServiceImpl.updateDepartment(id, updatedDepartment);
        Map<String, Object> response = new HashMap<>();
        response.put("data", department);
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/department/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteDepartment(@PathVariable String id) {
        departmentServiceImpl.deleteDepartment(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Department deleted successfully");
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/department/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> showDepartmentById(@PathVariable String id) {
        Departments department = departmentServiceImpl.showById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("data", department);
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

}
