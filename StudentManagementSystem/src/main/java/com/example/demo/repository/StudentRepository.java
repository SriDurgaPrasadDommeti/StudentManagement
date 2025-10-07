package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Student;

public interface StudentRepository extends JpaRepository< Student, Long> {
	List<Student> findByBranchBranchId(Long branchId);
}
