package com.example.Spr_HW_5.service;

import com.example.Spr_HW_5.model.Task;
import com.example.Spr_HW_5.model.TaskStatus;
import com.example.Spr_HW_5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    TaskRepository taskRepository;
    public List<Task> getAll(){
        return taskRepository.findAll();
    }
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task getByIdTask(Long id){
        return taskRepository.findById(id).get();
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public List<Task> filterTasks(TaskStatus taskStatus){
        return taskRepository.findByTaskStatus(taskStatus);
    }
}
