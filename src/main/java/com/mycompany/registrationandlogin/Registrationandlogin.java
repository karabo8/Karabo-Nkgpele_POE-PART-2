package com.mycompany.registrationandlogin;

import javax.swing.JOptionPane;

public class Registrationandlogin {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Task[] tasks;
    private int taskCount;
    private int totalHours = 0;

    public static void main(String[] args) {
        Registrationandlogin app = new Registrationandlogin();
        app.register();
        if (app.login()) {
            app.showMenu();
        }
    }

    public void register() {
        firstname = JOptionPane.showInputDialog("Enter your first name:");
        lastname = JOptionPane.showInputDialog("Enter your last name:");
        while (true) {
            username = JOptionPane.showInputDialog("Create a username (5 characters long, must contain an underscore):");
            if (checkUsernameComplexity(username)) {
                JOptionPane.showMessageDialog(null, "Username successfully captured!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure it contains an underscore and is 5 characters long.");
            }
        }

        while (true) {
            password = JOptionPane.showInputDialog("Create a password (at least 8 characters long, 1 uppercase letter, 1 number, 1 special character):");
            if (checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured!");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Ensure it contains at least 8 characters, 1 uppercase letter, 1 number, and a special character.");
            }
        }
    }

    public boolean login() {
        String inputUsername = JOptionPane.showInputDialog("Enter your username to login:");
        String inputPassword = JOptionPane.showInputDialog("Enter your password to login:");
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstname + " " + lastname + ", it's great to see you again!");
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login failed! Invalid username or password.");
            return false;
        }
    }

    public void showMenu() {
        String inputTasks = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        int numTasks = Integer.parseInt(inputTasks);
        tasks = new Task[numTasks];

        while (true) {
            String choice = JOptionPane.showInputDialog("1) Add Task\n2) Show Report\n3) Quit");
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }

    public void addTask() {
        if (taskCount >= tasks.length) {
            JOptionPane.showMessageDialog(null, "You have reached the maximum number of tasks.");
            return;
        }

        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description:");
        if (taskDescription.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            return;
        }

        String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
        String inputDuration = JOptionPane.showInputDialog("Enter task duration (hours):");
        int taskDuration = Integer.parseInt(inputDuration);
        String[] statusOptions = {"To Do", "Doing", "Done"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
        String taskID = createTaskID(taskName, taskCount, developerDetails);

        Task task = new Task(taskName, taskDescription, developerDetails, taskCount, taskDuration, taskStatus, taskID);
        tasks[taskCount] = task;
        taskCount++;
        totalHours += taskDuration;

        JOptionPane.showMessageDialog(null, task.printTaskDetails());
        JOptionPane.showMessageDialog(null, "Total Hours for all tasks: " + totalHours);
    }

    private String createTaskID(String taskName, int taskNumber, String developerDetails) {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String devInitials = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + devInitials;
    }

    private boolean checkUsernameComplexity(String username) {
        return username.length() == 5 && username.contains("_");
    }

    boolean checkPasswordComplexity(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&()]).{8,}$";
        return password.matches(passwordRegex);
    }

    public class Task {
        private String taskName;
        private String taskDescription;
        private String developerDetails;
        private int taskNumber;
        private int taskDuration;
        private String taskStatus;
        private String taskID;

        public Task(String taskName, String taskDescription, String developerDetails, int taskNumber, int taskDuration, String taskStatus, String taskID) {
            this.taskName = taskName;
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskNumber = taskNumber;
            this.taskDuration = taskDuration;
            this.taskStatus = taskStatus;
            this.taskID = taskID;
        }

        public String printTaskDetails() {
            return "Task Status: " + taskStatus + "\n" +
                   "Developer Details: " + developerDetails + "\n" +
                   "Task Number: " + taskNumber + "\n" +
                   "Task Name: " + taskName + "\n" +
                   "Task Description: " + taskDescription + "\n" +
                   "Task ID: " + taskID + "\n" +
                   "Duration: " + taskDuration + " hours";
        }
    }
}
