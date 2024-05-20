package com.twoLeeJung.ToDoList.service.taskService;

import com.twoLeeJung.ToDoList.domain.task.Task;
import com.twoLeeJung.ToDoList.domain.task.TaskRepository;
import com.twoLeeJung.ToDoList.dto.task.request.TaskCreateRequest;
import com.twoLeeJung.ToDoList.dto.task.request.TaskUpdateIsCompleted;
import com.twoLeeJung.ToDoList.dto.task.request.TaskUpdateNameRequest;
import com.twoLeeJung.ToDoList.dto.task.response.TaskResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public void saveTask(TaskCreateRequest request) {
        taskRepository.save(new Task(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> getTasks() {
        return taskRepository.findAll().stream()
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateTaskName(TaskUpdateNameRequest request) {
        Task task = taskRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        task.updateName(request.getName());
    }

    @Transactional
    public void updateTaskIsCompleted(TaskUpdateIsCompleted request) {
        Task task = taskRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        task.updateIsCompleted(request.isCompleted());
    }

    @Transactional
    public void deleteTask(long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        taskRepository.delete(task);
    }
}
