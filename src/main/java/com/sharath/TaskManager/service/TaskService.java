package com.sharath.TaskManager.service;

import com.sharath.TaskManager.dto.TaskRequest;
import com.sharath.TaskManager.model.Status;
import com.sharath.TaskManager.model.Task;
import com.sharath.TaskManager.repository.TaskRepository;
import com.sharath.TaskManager.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Collection<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {

        Task task = taskRepository.findById(id);

        if (task == null) {
            throw new TaskNotFoundException(id);
        }

        return task;
    }

    public Task createTask(TaskRequest request) {
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .status(Status.PENDING)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id);

        if(task == null) {
            return null;
        }

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setDueDate(request.getDueDate());
        task.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }
    public void deleteTask(Long id) {

        if (!taskRepository.exists(id)) {
            throw new TaskNotFoundException(id);
        }

        taskRepository.delete(id);
    }

    public Task markCompleted(Long id) {

        Task task = taskRepository.findById(id);

        if (task == null) {
            return null;
        }

        task.setStatus(Status.COMPLETED);
        task.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }
}
