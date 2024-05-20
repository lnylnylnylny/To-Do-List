package com.twoLeeJung.ToDoList.dto.task.response;

import com.twoLeeJung.ToDoList.domain.task.Task;

public class TaskResponse {

    private long id;
    private String name;
    private Boolean isCompleted;

    public TaskResponse(long id, String name, Boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.name = task.getName();
        this.isCompleted = task.getIsCompleted();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }
}
