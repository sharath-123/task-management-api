package com.sharath.TaskManager.controller;

import com.sharath.TaskManager.dto.TaskRequest;
import com.sharath.TaskManager.model.Task;
import com.sharath.TaskManager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
@Tag(
        name = "Task Management API",
        description = "REST APIs for creating, retrieving, updating, deleting and completing tasks."
)
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Get all tasks",
            description = "Returns a list of all tasks."
    )
    @GetMapping
    public ResponseEntity<Collection<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @Operation(
            summary = "Get task by ID",
            description = "Returns a task for the given ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @Operation(
            summary = "Create a new task",
            description = "Creates a new task with status PENDING."
    )
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest request) {
        Task task = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @Operation(
            summary = "Update an existing task",
            description = "Updates the title, description and due date of an existing task."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request) {

        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    @Operation(
            summary = "Delete a task",
            description = "Deletes a task using its ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Mark task as completed",
            description = "Updates the task status to COMPLETED."
    )
    @PatchMapping("/{id}/complete")
    public ResponseEntity<Task> completeTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.markCompleted(id));
    }
}