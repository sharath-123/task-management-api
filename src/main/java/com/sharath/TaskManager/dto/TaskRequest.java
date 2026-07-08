package com.sharath.TaskManager.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {

    @NotBlank(message = "Title is Required")
    private String title;

    @NotBlank(message = "Description is Required")
    private String description;

    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;
}
