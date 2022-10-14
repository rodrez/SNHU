package test;

import Appointment.Appointment;
import Appointment.AppointmentService;
import java.util.Date;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AppointmentServiceTest {

    @Test
    public void testDelete() {

        Date date = new Date();
        String description = "This is a valid description";
        AppointmentService cs = new AppointmentService();

        Appointment test1 = new Appointment(date, description);
        Appointment test2 = new Appointment(date, description);

        cs.addAppointment(test2);
        cs.addAppointment(test1);

        assertTrue(cs.deleteAppointment(test1.getID()));
        assertFalse(cs.deleteAppointment("1121212121212"));
    }

}
