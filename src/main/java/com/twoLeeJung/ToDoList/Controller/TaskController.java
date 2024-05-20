package com.twoLeeJung.ToDoList.Controller;

import com.twoLeeJung.ToDoList.dto.task.request.TaskCreateRequest;
import com.twoLeeJung.ToDoList.dto.task.request.TaskUpdateIsCompleted;
import com.twoLeeJung.ToDoList.dto.task.request.TaskUpdateNameRequest;
import com.twoLeeJung.ToDoList.dto.task.response.TaskResponse;
import com.twoLeeJung.ToDoList.service.taskService.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public void saveTask(@RequestBody TaskCreateRequest request) {
        taskService.saveTask(request);
    }

    @GetMapping("/task")
    public List<TaskResponse> getTasks() {
        return taskService.getTasks();
    }

    @PutMapping("/task/name")
    public void updateTaskName(@RequestBody TaskUpdateNameRequest request) {
        taskService.updateTaskName(request);
    }

    @PutMapping("/task/isComplete")
    public void updateTaskIsCompleted(@RequestBody TaskUpdateIsCompleted request) {
        taskService.updateTaskIsCompleted(request);
    }

    @DeleteMapping("/task")
    public void deleteTask(@RequestParam long id) {
        taskService.deleteTask(id);
    }
}
