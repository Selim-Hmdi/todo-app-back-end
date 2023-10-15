package com.selim.todoapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.selim.todoapp.models.TodoTask;
import com.selim.todoapp.repositories.TodoTaskRepository;

@Service
public class TodoTaskService {
    
    @Autowired
    private TodoTaskRepository todoTaskRepository;

    public List<TodoTask> findAll() {
        return todoTaskRepository.findAll();
    }

    public TodoTask findById(int id) {
        return todoTaskRepository.findById(id);
    }

    public void save(TodoTask taskToSave) {
        todoTaskRepository.save(taskToSave);
    }

    public void deleteById(int id) {
        todoTaskRepository.deleteById(id);
    }

    public void delete(TodoTask taskToDelete) {
        todoTaskRepository.delete(taskToDelete);
    }

    public long count() {
        return todoTaskRepository.count();
    }

    public boolean existById(int id) {
        return todoTaskRepository.existsById(id);
    }
}
