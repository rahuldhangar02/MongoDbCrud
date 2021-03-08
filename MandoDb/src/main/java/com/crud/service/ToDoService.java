package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.ToDo;
import com.crud.repository.ToDoRepository;


@Service
public class ToDoService {

	  @Autowired
	  private ToDoRepository todoRepo;
	  
	  // save To List
	  
	  public ToDo saveToDo(ToDo t)
	  {
		  return todoRepo.save(t);
	  }
	  
	
	  
	  public List<ToDo> toDoList()
	  {
		  return todoRepo.findAll();
	  }
	  
	  
}
