package com.ibm.spring_boot_security_latest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_security_latest.dto.Student;

@RestController
public class StudentController {
	
	@Autowired
	List<Student> students;
	
	@GetMapping(value = "/getAllStudents")
	@PreAuthorize(value = "hasRole('ADMIN')")
	public List<Student> getAllStudents(){
		
		students.add(new Student(567, "ansari", "ansari@gmail.com", 7867979879l));
		students.add(new Student(888, "abdulla", "abdulla@gmail.com", 879879l));
		students.add(new Student(999, "shaban", "shaban@gmail.com", 88887776655l));
		
		return students;
	}
}
