package com.example.xpgainer;

public class CTask {

    private String taskDescription;
    private static Integer id = 0;

    public CTask(){

    }

    public CTask(String taskDescription){

        this.taskDescription = taskDescription;
        CTask.id++;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
