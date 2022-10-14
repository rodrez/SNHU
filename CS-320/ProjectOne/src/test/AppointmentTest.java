package test;
import Appointment.Appointment;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentTest {

  @Test
    void testAppointment() {
        String description = "This is a valid description";
        Date date = new Date();
        Appointment appointment = new Appointment(date, description);
        assert(appointment.getDescription().equals(description));
        assert false;
    }

}
