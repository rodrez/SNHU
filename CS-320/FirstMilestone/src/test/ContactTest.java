package test;

import Contact.Contact;
import org.junit.jupiter.api.Test;

class ContactClassTest {

    static final String firstName = "Fabian";
    static final String lastName = "Rodriguez";
    static final String phone = "7171717717";
    static final String address = "Irving, TX";

    @Test
    void testContactClass() {
        Contact contactClass = new Contact(firstName, lastName, phone, address);
        assert (contactClass.getFirstName().equals(firstName)); // Checks firstName
        assert (contactClass.getLastName().equals(lastName)); // Checks lastName
        assert (contactClass.getPhone().equals(phone)); // Checks phone
        assert (contactClass.getAddress().equals(address)); // Checks address
    }


}