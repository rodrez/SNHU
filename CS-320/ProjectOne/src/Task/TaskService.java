package Task;

import java.util.ArrayList;

public class TaskService {
    // Holds the list of tasks
    private final ArrayList<Task> tasks;

    public TaskService() {
        // Initialize the array list
        tasks = new ArrayList<>();
    }

    // Method to add a task
    public boolean addTask(Task task) {
        boolean isInArray = false;
        // Loops through all the task
        for (Task taskObject : tasks) {
            // Checks if the task object is in the array
            if (taskObject.equals(task)) {
                isInArray = true;
                break;
            }
        }
        // If the task is not in the array, add it
        if (!isInArray) {
            tasks.add(task);
            // Returns true if the task was added successfully
            return true;
        }
        // Returns false if the task was not added successfully
        return false;

    }

    // Method to find the task by id
    public Task getTask(String id) {
        for (Task taskObject : tasks) {
            // Checks if there is a task with that id
            if (taskObject.getID().equals(id)) {
                return taskObject;
            }
        }
        return null;
    }

    // Method to delete a task by id
    public boolean deleteTask(String id) {
        Task task = getTask(id);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        ;
        return false;
    }

    // Method to validate the field is not null or exceeds the length
    public boolean isValid(String field, int maxLength) {
        return !(field.equals("") || field.length() > maxLength);
    }

    // Method to update and check the validity of the fields
    public boolean updateTask(String id, String name, String description) {

        // Gets the task
        Task task = getTask(id);

        if (isValid(name, 20) &&
                isValid(description, 50)) {
            task.setName(name);
            task.setDescription(description);

            return true;
        }

        return false;
    }

}
