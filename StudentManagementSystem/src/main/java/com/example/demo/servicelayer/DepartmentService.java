package com.example.demo.servicelayer;

import java.util.List;

import com.example.demo.dto.Branch;
import com.example.demo.dto.Department;

public interface DepartmentService {
	
	Department addDepartment(Department dept);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department dept);
    void deleteDepartment(Long id);
    List<Branch> getBranchesByDept(Long deptId);
    public Department isActive(Long id,Department dept);

}
