package com.selim.todoapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.selim.todoapp.models.TodoTask;
import com.selim.todoapp.services.TodoTaskService;

@RestController
@RequestMapping("todo-task")
public class TodoTaskController {

    @Autowired
    private TodoTaskService todoTaskService;

    @GetMapping("/")
    public ResponseEntity<List<TodoTask>> findAll() {
        List<TodoTask> allTasks = todoTaskService.findAll();
        
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoTask> findById(@PathVariable int id) {
        TodoTask taskFound = todoTaskService.findById(id);

        return ResponseEntity.ok(taskFound);
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody TodoTask task) {
        todoTaskService.save(task);
        return ResponseEntity.ok(task.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoTask> update(@RequestBody TodoTask recievedTask, @PathVariable int id) {
        TodoTask updatedTask = todoTaskService.findById(id);
        updatedTask.setText(recievedTask.getText());
        todoTaskService.save(updatedTask);

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoTask> delete(@PathVariable int id) {
        TodoTask taskToDelete = todoTaskService.findById(id);
        if(taskToDelete == null) return ResponseEntity.notFound().build();

        todoTaskService.delete(taskToDelete);

        return ResponseEntity.ok(taskToDelete);
    }
}
