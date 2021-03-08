package com.crud.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.crud.model.ToDo;

@Repository
public interface ToDoRepository extends MongoRepository<ToDo,Integer> {

	
}
