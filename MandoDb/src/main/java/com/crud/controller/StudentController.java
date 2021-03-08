package com.crud.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.model.Student;
import com.crud.repository.StudentRepository;
import com.crud.service.StudentService;
import com.crud.controller.StudentController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	   @Autowired
	   private StudentService studServcie;
	   
	  @Autowired
	  private StudentRepository repo;
	
	   
	   // get Student
	   @GetMapping("/list")
	   public ResponseEntity<List<Student>>  getStudent()
	   {
		   logger.info("fetch All Records..");
		   List<Student> list=repo.findAll();
		    
		    	return ResponseEntity.ok(list);
		   
		   
	   }
	  
	   // get Student by id
	   @GetMapping("/get/{id}")
	   public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") int id)
	   {
		   Optional<Student> student=studServcie.getStudentById(id);
		   
		   return ResponseEntity.ok(student);
	   }
	   
	   // save Student
	    
	   @PostMapping("/save")
	   public ResponseEntity<Student> saveStudent(@RequestBody Student s)
	   {
		   
		   
		   Student student=repo.save(s);
			
			URI location=ServletUriComponentsBuilder.
			fromCurrentContextPath()
			.path("{/id}")
			.buildAndExpand(student.getId())
			.toUri();
			
			
			return ResponseEntity.created(location).build();
	   }
	   
	   @DeleteMapping("delete/{id}")
		  public ResponseEntity<Void> delStudent(@PathVariable("id") int id)
		  {
		    	  studServcie.deleteStudentById(id);
		    	  
			return  ResponseEntity.noContent().build();
		  }
	   
	   
	   // Update Student Data
	   @PutMapping("/update/{id}")
	   public ResponseEntity<Student> UpdateStudent(@RequestBody Student s,@PathVariable("id") int id)
	   {
		   Student stud=repo.findById(id).get();
		   
		   if(stud!=null)
			   stud.setName(s.getName());
		       stud.setSalary(s.getSalary());
		       stud.setGender(s.getGender());
		       return ResponseEntity.ok(repo.save(stud));
		   
	   }
	   
	   
}
