package test;

import Contact.Contact;
import Contact.ContactService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {

    @Test
    public void testDelete() {
        ContactService cs = new ContactService();

        Contact test1 = new Contact("John", "Doe", "7177177777", "Some Address");
        Contact test2 = new Contact("Jane", "Doe", "8188188888", "Some Address");
        Contact test3 = new Contact("Scott", "Wood", "9199199999", "Some Address");

        cs.addContact(test2);
        cs.addContact(test1);
        cs.addContact(test3);

        assertTrue(cs.deleteContact(test1.getID()));
        assertFalse(cs.deleteContact("1121212121212"));
        assertFalse(cs.deleteContact("1212121212121"));
    }

    @Test
    public void testUpdate() {
        ContactService cs = new ContactService();

        Contact test1 = new Contact("Jane", "Doe", "333333", "Some Address");
        Contact test2 = new Contact("John", "Doe", "2222222222", "Some Address");
        Contact test3 = new Contact("Scott", "Wood", "1111111111", "Some Address");

        cs.addContact(test1);
        cs.addContact(test2);
        cs.addContact(test3);

        assertTrue(cs.updateContact(test1.getID(), "Draco", "Malfoy", "1231234545", "Hogwarts"));
        assertFalse(cs.updateContact(test2.getID(), "Darth", "Vader", "7177171000000", "Death Star"));
    }
}