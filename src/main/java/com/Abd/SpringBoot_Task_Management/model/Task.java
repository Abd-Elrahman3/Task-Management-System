package com.Abd.SpringBoot_Task_Management.model;

import com.Abd.SpringBoot_Task_Management.model.Priority;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Task{
    private int Id;
    private String name;
    private LocalDateTime startingDate;
    private Priority priority;
    private Status statues;
    private String description;
    private LocalDateTime dueDate;

    public Task(int id, String name, Priority priotity, Status statues, String description, LocalDateTime dueDate) {
        Id = id;
        this.name = name;
        this.startingDate = LocalDateTime.now();
        this.priority = priotity;
        this.statues = statues;
        this.description = description;
        this.dueDate = dueDate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartingDateDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priotity) {
        this.priority = priotity;
    }

    public Status getStatues() {
        return statues;
    }

    public void setStatues(Status statues) {
        this.statues = statues;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {return dueDate;}

    public void setDueDate(LocalDateTime dueDate) {this.dueDate = dueDate;}
}
