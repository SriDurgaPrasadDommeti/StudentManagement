package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
	List<Branch> findByDepartmentDeptId(Long deptId);
}
