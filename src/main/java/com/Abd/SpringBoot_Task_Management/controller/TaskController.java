package com.Abd.SpringBoot_Task_Management.controller;

import com.Abd.SpringBoot_Task_Management.model.Priority;
import com.Abd.SpringBoot_Task_Management.model.Status;
import com.Abd.SpringBoot_Task_Management.model.Task;
import com.Abd.SpringBoot_Task_Management.repository.CreateTaskRequest;
import com.Abd.SpringBoot_Task_Management.repository.UpdateTaskRequest;
import com.Abd.SpringBoot_Task_Management.service.TaskService;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Scope("prototype")
public class TaskController {

    TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody CreateTaskRequest request) {
        taskService.createTask(request);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(@RequestParam(required = false) Status status,
                                  @RequestParam(required = false) Priority priority) {
        return taskService.getAllTasks(status, priority);
    }

    @GetMapping("/tasks/{Id}")
    public Task getTaskById(@PathVariable int Id) {
        return taskService.getTaskById(Id);
    }

    @PutMapping("/tasks")
    public Task updateTask(@RequestBody UpdateTaskRequest request) {
        return taskService.updateTask(request);
    }

    @DeleteMapping("/tasks/{Id}")
    public void deleteTask(@PathVariable int Id) {
        taskService.deleteTask(Id);
    }


}
