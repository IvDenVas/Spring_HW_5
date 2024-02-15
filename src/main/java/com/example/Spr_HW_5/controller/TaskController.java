package com.example.Spr_HW_5.controller;

import com.example.Spr_HW_5.model.Task;
import com.example.Spr_HW_5.model.TaskStatus;
import com.example.Spr_HW_5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    TaskService taskService;
    @GetMapping
    public List<Task> show(){
        return taskService.getAll();
    }
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getByIdTask(id);
    }
    @DeleteMapping("/del/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable("status") TaskStatus status) {
        return taskService.filterTasks(status);
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable("id") Long id, @RequestBody Task task) {
        Task updateTask = taskService.getByIdTask(id);
        updateTask.setDate(task.getDate());
        updateTask.setDescription(task.getDescription());
        updateTask.setTaskStatus(task.getTaskStatus());
        return taskService.addTask(updateTask);
    }
}
