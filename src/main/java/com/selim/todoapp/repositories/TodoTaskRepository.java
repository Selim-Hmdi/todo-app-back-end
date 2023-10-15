package com.selim.todoapp.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import com.selim.todoapp.models.TodoTask;

@Repository
public interface TodoTaskRepository extends  ListCrudRepository<TodoTask, Integer>{
    TodoTask findById(int id);
}
