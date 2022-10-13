package Appointment;

import java.util.UUID;
import java.util.Date;

public class Appointment {
    private String id;
    private Date date;
    private String description;

    private static final int ID_LENGTH = 10;
    private static final int DESCRIPTION_LENGTH = 50;

    public String getID() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
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
        String uuid = UUID.randomUUID().toString(); // Set appointment ID
        this.id = uuid.substring(uuid.length() - 16);
    }

    // Simplify the code above by using the constructor low
    public Appointment(Date date, String description) {
        setUniqueId();
        setDate(date);
        setDescription(description);

        System.out.printf("%s", this.toString());
    }

    @Override
    public String toString() {
        return "Appointment: ID=" + id + ", date=" + date + ", description=" + description;
    }
}
