package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /// Save Department
    @PostMapping("/departments/save")
    public Department saveDepartment (@Validated @RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    /// Read Operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    /// Update Operation
    @PutMapping("/department/update/{id}")
    public Department updateDepartment (@RequestBody Department department, @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(department, departmentId);
    }

    /// Delete Operation
    @DeleteMapping("/department/delete/{id}")
    public String deleteDepartmentById (@PathVariable ("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully.";
    }

}
