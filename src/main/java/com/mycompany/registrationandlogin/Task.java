/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrationandlogin;
import javax.swing.*;

/**
 *
 * @author nkgap
 */

// Declaractions 
public class Task {
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskNumber;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    
    // Constructor to initialize task fields and auto-generate task ID
    public Task(String taskName, String taskDescription, String developerDetails, int taskNumber, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskNumber = taskNumber;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }

    // Method to check if the task description meets the character limit requirement
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

     // Method to create a unique Task ID based on task name, task number, and developer's name
    public String createTaskID() {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String devInitials = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + devInitials;
    }

    // Method to return a formatted string with all task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    // Method to return the duration of this task, useful for accumulating total hours
    public int returnTotalHours() {
        return this.taskDuration;
    }
}