package Task;

import java.util.UUID;

public class Task {
  private String name;
  private String description;
  private String id;

  private static final int NAME_LENGTH = 20;
  private static final int DESCRIPTION_LENGTH = 50;

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getID() {
    return id;
  }

  // Setters and validation
  // Update one or more description fields
  protected void setName(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name must not be empty");
    } else if (name.length() > NAME_LENGTH) {
      throw new IllegalArgumentException("Name must not exceed " +
          NAME_LENGTH + " characters");
    }
    this.name = name;
  }

  protected void setDescription(String description) {
    if (name == null) {
      throw new IllegalArgumentException("Description must not be empty");
    } else if (description.length() > DESCRIPTION_LENGTH) {
      throw new IllegalArgumentException("Description must not exceed " +
          DESCRIPTION_LENGTH + " characters");
    }
    this.description = description;
  }

  protected void setUniqueId() {
    String uuid = UUID.randomUUID().toString(); // Set task ID
    this.id = uuid.substring(uuid.length() - 16);
  }

  // Simplify the code above by using the constructor below
  public Task(String name, String description) {
    setUniqueId();
    setName(name);
    setDescription(description);

    System.out.printf("%s", this.toString());
  }

  @Override
  public String toString() {
    return "Task: ID=" + id + ", name=" + name + ", description=" + description;
  }
}
