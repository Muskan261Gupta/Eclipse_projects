package com.nagarro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.StudentNotFound;
import com.nagarro.entity.Student;
import com.nagarro.repository.StudentRepo;

@Service
public class StudentService {
	
	
	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	public void deleteStudent(int rollno) throws StudentNotFound {
		// TODO Auto-generated method stub
		studentRepo.deleteById(rollno);
		Student student=studentRepo.findById(rollno).get();
			if(student!=null) {
				studentRepo.deleteById(rollno);
			}
			else {
				throw new StudentNotFound("Student not exist");
			}

		//return studentRepo.findById(rollno).orElseThrow(StudentNotFound::new);
	}

	public Optional<Student> getOneStudent(int rollno) {
		// TODO Auto-generated method stub
		return studentRepo.findById(rollno);
		//return studentRepo.findById(rollno).orElseThrow(StudentNotFound::new);
	}

	public Student updateStudent(Student student, int rollno) {
		// TODO Auto-generated method stub
		//studentRepo.save(student);
		Student oldstudent=studentRepo.findById(rollno).get();
		oldstudent.setName(student.getName());
		oldstudent.setMarks(student.getMarks());
		oldstudent.setResult(student.getResult());
		return studentRepo.save(oldstudent);
		//return student;
	}

}
