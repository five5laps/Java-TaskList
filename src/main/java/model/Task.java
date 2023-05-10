package model;

import java.sql.Timestamp;

public class Task {
    private Timestamp datecreated;
    private String description;
    private String task;
    private int userId;

    public Task() {
    }

    public Task(int userId, Timestamp datecreated, String description, String task) {
        this.userId = userId;
        this.datecreated = datecreated;
        this.description = description;
        this.task = task;
    }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
