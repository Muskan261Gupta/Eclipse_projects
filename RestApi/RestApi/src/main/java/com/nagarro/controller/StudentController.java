package com.nagarro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.StudentNotFound;
import com.nagarro.entity.Student;
import com.nagarro.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	@ResponseStatus(HttpStatus.OK)
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();		
		
	}
	
	@PostMapping("/student")
	@ResponseStatus(HttpStatus.CREATED)
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/student/{rollno}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteStudent(@PathVariable("rollno") int rollno) {
		
		try {
			studentService.deleteStudent(rollno);
		} catch (StudentNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Deleted Sucessfully";
		
	}
	
	@GetMapping("/student/{rollno}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Student> getOneStudent(@PathVariable("rollno") int rollno) {
		
		return studentService.getOneStudent(rollno);
	}
	
	@PutMapping("/student/{rollno}")
	@ResponseStatus(HttpStatus.CREATED)
	public Student updateStudent(@RequestBody Student student,@PathVariable("rollno") int rollno) {
		return studentService.updateStudent(student,rollno);
	}
}
