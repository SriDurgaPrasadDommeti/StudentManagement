package com.example.demo.servicelayer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Branch;
import com.example.demo.dto.Department;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final BranchRepository branchRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, BranchRepository branchRepository) {
        this.departmentRepository = departmentRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Department addDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department dept) {
        Optional<Department> existing = departmentRepository.findById(id);
        if (existing.isPresent()) {
            Department department = existing.get();
            department.setDeptName(dept.getDeptName());
            department.setIsActive(dept.getIsActive());
            return departmentRepository.save(department);
        }
        return null;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Branch> getBranchesByDept(Long deptId) {
        return branchRepository.findByDepartmentDeptId(deptId);
    }

     
	public Department isActive(Long id, Department dept) {
		 Department d=departmentRepository.findById(id).get();
		 if(d!=null) {
			  if(dept.getIsActive()!=null) {
				d.setIsActive(dept.getIsActive()); 
			  }
			 return departmentRepository.save(d);
		 }else {
	            throw new RuntimeException("Student not found with id " + id);
	     }
		 
	}
    
}

