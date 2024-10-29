package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

public class TaskTest {
    private Registrationandlogin.Task task;

    @BeforeEach
    public void setUp() {
        Registrationandlogin registrationAndLogin = new Registrationandlogin();
        task = registrationAndLogin.new Task("CodeReview", "Review code for task module", "JohnDoe", 1, 5, "To Do", "CO:1:DOE");
    }

    @Test
    public void testTaskIDGeneration() throws NoSuchFieldException, IllegalAccessException {
        Field taskIDField = task.getClass().getDeclaredField("taskID");
        taskIDField.setAccessible(true);
        String taskID = (String) taskIDField.get(task);
        String expectedTaskID = "CO:1:DOE";
        assertEquals(expectedTaskID, taskID, "Generated Task ID should match the expected format.");
    }

    @Test
    public void testPrintTaskDetails() {
        String details = task.printTaskDetails();
        assertNotNull(details, "Task details should not be null.");
        assertTrue(details.contains("Task Status: To Do"), "Details should contain 'Task Status: To Do'");
    }
}