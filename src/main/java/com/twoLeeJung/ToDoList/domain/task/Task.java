package com.twoLeeJung.ToDoList.domain.task;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private boolean isCompleted;

    protected Task() {}

    public Task(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
