package com.example.tarefa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tarefa.config.TaskConfig;
import com.example.tarefa.model.Task;
import com.example.tarefa.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Task not found"));
    }
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
