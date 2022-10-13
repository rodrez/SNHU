
package Appointment;

import java.util.ArrayList;

public class AppointmentService {
    // Holds the list of appt 
    private final ArrayList<Appointment> appointments;

    public AppointmentService() {
        // Initialize the array list
        appointments = new ArrayList<>();
    }

    // Method to add a appt 
    public boolean addAppointment(Appointment appointment) {
        boolean isInArray = false;
        // Loops through all the appt 
        for (Appointment appointmentObject : appointments ) {
            // Checks if the appt object is in the array
            if (appointmentObject.equals(appointment)) {
                isInArray = true;
                break;
            }
        }
        // If the appt is not in the array, add it
        if (!isInArray) {
            appointments.add(appointment);
            // Returns true if the appt was added successfully
            return true;
        }
        // Returns false if the appt was not added successfully
        return false;

    }

    // Method to find the appt by id
    public Appointment getAppointment(String id) {
        for (Appointment appointmentObject : appointments) {
            // Checks if there is a appt with that id
            if (appointmentObject.getID().equals(id)) {
                return appointmentObject;
            }
        }
        return null;
    }

    // Method to delete a appt by id
    public boolean deleteAppointment(String id) {
        Appointment appointment = getAppointment(id);
        if (appointment != null) {
            appointment.remove(appointment);
            return true;
        }
        ;
        return false;
    }

    // Method to validate the field is not null or exceeds the length
    public boolean isValid(String field, int maxLength) {
        return !(field.equals("") || field.length() > maxLength);
    }

}
