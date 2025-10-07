package com.example.demo.servicelayer;

import java.util.List;

import com.example.demo.dto.Student;

public interface StudentService {
	
	Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);

}
