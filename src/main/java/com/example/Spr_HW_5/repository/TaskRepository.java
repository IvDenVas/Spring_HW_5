package com.example.Spr_HW_5.repository;

import com.example.Spr_HW_5.model.Task;
import com.example.Spr_HW_5.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(TaskStatus taskStatus);
}
