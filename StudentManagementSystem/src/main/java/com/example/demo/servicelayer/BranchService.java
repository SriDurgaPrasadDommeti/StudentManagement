package com.example.demo.servicelayer;

import java.util.List;

import com.example.demo.dto.Branch;
import com.example.demo.dto.Student;

public interface BranchService {
	
	Branch addBranch(Branch branch);
    List<Branch> getAllBranches();
    Branch getBranchById(Long id);
    Branch updateBranch(Long id, Branch branch);
    void deleteBranch(Long id);
    List<Student> getStudentsByBranch(Long branchId);

}
