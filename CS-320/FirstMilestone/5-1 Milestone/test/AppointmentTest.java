package test;
import Appointment.Appointment;
import java.util.Date;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

  @Test
    void testAppointment() {
        String description = "This is a valid description";
        Date date = new Date();
        Appointment appointment = new Appointment(date, description);
        assert(appointment.getDescription().equals(description));
        assert(appointment.getDate().equals(date));
    }

}
