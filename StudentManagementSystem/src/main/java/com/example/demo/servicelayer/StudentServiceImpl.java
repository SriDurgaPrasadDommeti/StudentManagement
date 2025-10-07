package com.example.demo.servicelayer;

import com.example.demo.dto.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.servicelayer.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, Student incoming) {
        return studentRepository.findById(id).map(existing -> {
            // Strings / objects: only overwrite if not null
            if (incoming.getFirstName() != null) existing.setFirstName(incoming.getFirstName());
            if (incoming.getLastName()  != null) existing.setLastName(incoming.getLastName());
            if (incoming.getGender()    != null) existing.setGender(incoming.getGender());
            if (incoming.getDob()       != null) existing.setDob(incoming.getDob());
            if (incoming.getMobile()    != null) existing.setMobile(incoming.getMobile());
            if (incoming.getEmail()     != null) existing.setEmail(incoming.getEmail());
            if (incoming.getStreet()    != null) existing.setStreet(incoming.getStreet());
            if (incoming.getCity()      != null) existing.setCity(incoming.getCity());
            if (incoming.getState()     != null) existing.setState(incoming.getState());
            if (incoming.getZipcode()   != null) existing.setZipcode(incoming.getZipcode());
            if (incoming.getCountry()   != null) existing.setCountry(incoming.getCountry());
            // primitives: apply only if a meaningful value is sent
            if (incoming.getAge() != 0) existing.setAge(incoming.getAge());

            // relation: set only if provided (expects { "branch": { "branchId": X } } in JSON)
            if (incoming.getBranch() != null) existing.setBranch(incoming.getBranch());

            return studentRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
     
}
