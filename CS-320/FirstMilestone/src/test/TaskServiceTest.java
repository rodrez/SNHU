package test;

import Task.Task;
import Task.TaskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testDelete() {
        TaskService cs = new TaskService();

        Task test1 = new Task("Learn Java", "Learn the java programming language.");
        Task test2 = new Task("Learn Python", "Learn the python programming language.");
        Task test3 = new Task("Learn Rust", "Learn the rust programming language.");

        cs.addTask(test2);
        cs.addTask(test1);
        cs.addTask(test3);

        assertTrue(cs.deleteTask(test1.getID()));
        assertFalse(cs.deleteTask("1121212121212"));
        assertFalse(cs.deleteTask("1212121212121"));
    }

    @Test
    public void testUpdate() {
        TaskService cs = new TaskService();

        Task test1 = new Task("Learn Java", "Learn the java programming language.");
        Task test2 = new Task("Learn Python", "Learn the python programming language.");
        Task test3 = new Task("Learn Rust", "Learn the rust programming language.");

        cs.addTask(test1);
        cs.addTask(test2);
        cs.addTask(test3);

        assertTrue(cs.updateTask(test1.getID(), "Learn Dart", "Learn the dart programming language."));
        assertFalse(cs.updateTask(test2.getID(), "Learn C++", "Learn the C++ programming language.Learn the C++ programming language.Learn the C++ programming language."));
    }
}