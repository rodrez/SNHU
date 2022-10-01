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
