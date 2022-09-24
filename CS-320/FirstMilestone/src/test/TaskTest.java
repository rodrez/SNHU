package test;

import Task.Task;
import org.junit.jupiter.api.Test;

class TaskClassTest {

    static final String name = "Learn Testing";
    static final String description = "Learn and enforce testing in applications";

    @Test
    void testTaskClass() {
        Task taskClass = new Task(name, description);
        assert (taskClass.getName().equals(name)); // Checks name
        assert (taskClass.getDescription().equals(description)); // Checks description
    }


}