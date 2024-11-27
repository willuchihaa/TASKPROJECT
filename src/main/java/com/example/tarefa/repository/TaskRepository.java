package com.example.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tarefa.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
