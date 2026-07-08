package com.sharath.TaskManager.service;

import com.sharath.TaskManager.dto.TaskRequest;
import com.sharath.TaskManager.model.Status;
import com.sharath.TaskManager.model.Task;
import com.sharath.TaskManager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldCreateTaskSuccessfully() {

        TaskRequest request = new TaskRequest();
        request.setTitle("Learn Spring Boot");
        request.setDescription("Complete Wellness360 Assignment");
        request.setDueDate(LocalDate.now().plusDays(2));

        Task savedTask = Task.builder()
                .id(1L)
                .title(request.getTitle())
                .description(request.getDescription())
                .dueDate(request.getDueDate())
                .status(Status.PENDING)
                .build();

        when(taskRepository.save(any(Task.class)))
                .thenReturn(savedTask);

        Task result = taskService.createTask(request);

        assertNotNull(result);
        assertEquals("Learn Spring Boot", result.getTitle());
        assertEquals(Status.PENDING, result.getStatus());

        verify(taskRepository, times(1))
                .save(any(Task.class));
    }
    @Test
    void shouldMarkTaskAsCompleted() {

        Task task = Task.builder()
                .id(1L)
                .title("Task")
                .description("Description")
                .dueDate(LocalDate.now().plusDays(1))
                .status(Status.PENDING)
                .build();

        when(taskRepository.findById(1L)).thenReturn(task);
        when(taskRepository.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task result = taskService.markCompleted(1L);

        assertEquals(Status.COMPLETED, result.getStatus());

        verify(taskRepository).findById(1L);
        verify(taskRepository).save(task);

    }
}