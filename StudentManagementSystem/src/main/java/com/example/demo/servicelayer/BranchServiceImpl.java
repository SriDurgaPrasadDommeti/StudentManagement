package com.example.demo.servicelayer;

import com.example.demo.dto.Branch;
import com.example.demo.dto.Student;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.servicelayer.BranchService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StudentRepository studentRepository;

    public BranchServiceImpl(BranchRepository branchRepository, StudentRepository studentRepository) {
        this.branchRepository = branchRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Branch addBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElse(null);
    }

    @Override
    public Branch updateBranch(Long id, Branch branch) {
        Optional<Branch> existing = branchRepository.findById(id);
        if (existing.isPresent()) {
            Branch br = existing.get();
            br.setBranchName(branch.getBranchName());
            br.setRoomNo(branch.getRoomNo());
            br.setSection(branch.getSection());
            br.setDepartment(branch.getDepartment());
            return branchRepository.save(br);
        }
        return null;
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByBranch(Long branchId) {
        return studentRepository.findByBranchBranchId(branchId);
    }
}
