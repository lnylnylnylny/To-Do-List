package com.twoLeeJung.ToDoList.dto.task.request;

public class TaskUpdateIsCompleted {

    private long id;
    private boolean isCompleted;

    public TaskUpdateIsCompleted(long id, boolean isCompleted) {
        this.id = id;
        this.isCompleted = isCompleted;
    }

    public long getId() {
        return id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
