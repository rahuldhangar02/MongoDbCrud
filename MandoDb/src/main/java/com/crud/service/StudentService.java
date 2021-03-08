package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Student;
import com.crud.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studRepo;
	
	
	/// list student
	
	public List<Student> getAllStudent()
	{
		return studRepo.findAll();
	}
	
	// save Student
	
	public Student saveStudent(Student student)
	{
		return studRepo.save(student);
	}
	
	// get Student
	public Optional<Student> getStudentById(int id)
	{
		
		return studRepo.findById(id);
	}
	
	// delete Student by Id
	
	public void deleteStudentById(int id)
	{
		studRepo.deleteById(id);
	}
	
}
