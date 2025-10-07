package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long deptId;

	    private String deptName;
	    
	    private Boolean isActive;
	    @OneToMany(mappedBy = "department")
	    @JsonManagedReference
	    private List<Branch> branches;

		public Long getDeptId() {
			return deptId;
		}

		public void setDeptId(Long deptId) {
			this.deptId = deptId;
		}

		public String getDeptName() {
			return deptName;
		}

		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}

		public List<Branch> getBranches() {
			return branches;
		}

		public void setBranches(List<Branch> branches) {
			this.branches = branches;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		 
	    
	    

}
