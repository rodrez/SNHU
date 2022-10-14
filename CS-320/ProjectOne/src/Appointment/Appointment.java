package Appointment;

import java.util.Date;
import java.util.UUID;

public class Appointment {
    private String id;
    private String date;
    private String description;

    private static final int ID_LENGTH = 10;
    private static final int DESCRIPTION_LENGTH = 50;

    public String getID() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        if (description == null) {
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

    protected void setDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Date must not be empty");
        }
        this.date = date;
    }

    // Simplify the code above by using the constructor low
    public Appointment(Date date, String description) {
        setUniqueId();
        setDate(String.valueOf(date));
        setDescription(description);

        System.out.printf("%s", this.toString());
    }

    @Override
    public String toString() {
        return "Appointment: ID=" + id + ", date=" + date + ", description=" + description;
    }

}
