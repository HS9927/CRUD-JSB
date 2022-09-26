package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /// Save Operation
    @Override
    public Department saveDepartment (Department department)
    {
        return departmentRepository.save(department);
    }

    /// Read Operation
    @Override
    public List<Department> fetchDepartmentList()
    {
        return (List<Department>) departmentRepository.findAll();
    }

    /// Update Operation
    @Override
    public Department updateDepartment (Department department, Long departmentId)
    {
        Department depDB = departmentRepository.findById(departmentId).get();

        /// department Name
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        /// department address
        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        /// department code
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }


}
