package com.sharath.TaskManager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
