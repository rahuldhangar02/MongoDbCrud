package com.crud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.model.Student;
import com.crud.model.ToDo;
import com.crud.repository.ToDoRepository;
import com.crud.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

   @Autowired
    private ToDoService todoService;
	
     @Autowired
	  private ToDoRepository repo;
	
     //
     @GetMapping("/list")
	   public ResponseEntity<List<ToDo>>  getStudent()
	   {
		   List<ToDo> list=repo.findAll();
		   
		   return ResponseEntity.ok(list);
	   }
     
     
	// Save To do List
	  @PostMapping("/save")
	  public ResponseEntity<ToDo> saveToDoList(@RequestBody ToDo t)
	  {
		  
		  
		  ToDo todo=repo.save(t);
		  
		  URI location=ServletUriComponentsBuilder
				      .fromCurrentContextPath()
				      .path("{/id}")
				      .buildAndExpand(todo.getId()).toUri();
		  return ResponseEntity.created(location).build();
		  
	  }
	
	  // fetch List
	 
}
