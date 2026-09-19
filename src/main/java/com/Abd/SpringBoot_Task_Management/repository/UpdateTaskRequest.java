package com.Abd.SpringBoot_Task_Management.repository;

import com.Abd.SpringBoot_Task_Management.model.Status;
import com.Abd.SpringBoot_Task_Management.model.Priority;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record UpdateTaskRequest(
        int Id,
        String name,
        LocalDateTime dueDate,
        Priority priority,
        String description,
        Status status
) {
}
