package com.Abd.SpringBoot_Task_Management.service;

import com.Abd.SpringBoot_Task_Management.model.Priority;
import com.Abd.SpringBoot_Task_Management.model.Status;
import com.Abd.SpringBoot_Task_Management.model.Task;
import com.Abd.SpringBoot_Task_Management.repository.CreateTaskRequest;
import com.Abd.SpringBoot_Task_Management.repository.UpdateTaskRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    List<Task> tasks = new ArrayList<>();
    private int nextId = 1;


    // create task
    public Task createTask(CreateTaskRequest request) {
        Status status;
        if (request.dueDate().isBefore(LocalDateTime.now()))
            status = Status.DONE;
        else status = Status.TODO;
        Task task = new Task(
                nextId++,
                request.name(),
                request.priority(),
                status,
                request.description(),
                request.dueDate());
        tasks.add(task);
        return task;
    }
    // get all tasks
    public List<Task> getAllTasks(Status status, Priority priority) {
        return tasks.stream()
                .filter(task -> status == null || task.getStatues() == status)
                .filter(task -> priority == null || task.getPriority() == priority)
                .toList();
    }
    // get a task by Id

    public Task getTaskById(int Id) {

        return tasks.stream()
                .filter(task -> task.getId() == Id)
                .findFirst()
                .orElseThrow();
    }
    //update task
    public Task updateTask(UpdateTaskRequest request) {
        Task updatedTask = null;
        for (Task task : tasks) {
            if (task.getId() == request.Id()){
                task.setName(request.name());
                task.setDescription(request.description());
                task.setDueDate(request.dueDate());
                task.setPriority(request.priority());
                task.setStatues(request.status());
            }
            updatedTask = task;
        }
        return updatedTask;
    }
    // delete task

    public void deleteTask(int Id) {

        Task task = tasks.stream()
                .filter(t -> t.getId() == Id)
                .findFirst()
                .orElseThrow();
        tasks.remove(task);
    }
    // get completed tasks

}
