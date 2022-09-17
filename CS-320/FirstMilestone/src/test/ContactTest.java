package test;

import Contact.Contact;
import static org.junit.jupiter.api.Assertions.*;

class ContactClassTest {

    static final String firstName = "Fabian";
    static final String lastName = "Rodriguez";
    static final String phone = "7171717717";
    static final String address = "Irving, TX";
    static final String id = "1";

    void testContactClass() {
        Contact contactClass = new Contact(firstName, lastName, phone, address, id);
        assert (contactClass.getFirstName().equals(firstName)); // Checks firstName
        assert (contactClass.getLastName().equals(lastName)); // Checks lastName
        assert (contactClass.getPhone().equals(phone)); // Checks phone
        assert (contactClass.getAddress().equals(address)); // Checks address
        assert (contactClass.getID().equals(id)); // Checks id
    }

    @Test
    void testContactClassFieldTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Fabiannnnnn", lastName, phone, address, id);
        });
    }

}