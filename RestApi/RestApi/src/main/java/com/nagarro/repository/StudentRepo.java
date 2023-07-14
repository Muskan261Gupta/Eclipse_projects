package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
