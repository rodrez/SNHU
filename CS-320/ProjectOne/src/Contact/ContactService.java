package Contact;

import java.util.ArrayList;

public class ContactService {
    // Holds the list of contacts
    private final ArrayList<Contact> contacts;

    public ContactService() {
        // Initialize the array list
        contacts = new ArrayList<>();
    }

    // Method to add contact
    public boolean addContact(Contact contact) {
        boolean isInArray = false;
        // Loops through all the contacts
        for (Contact contactObject : contacts) {
            // Checks if the contact object is in the array
            if (contactObject.equals(contact)) {
                isInArray = true;
                break;
            }
        }
        // If the contact is not in the array, add it
        if (!isInArray) {
            contacts.add(contact);
            // Returns true if the contact was added successfully
            return true;
        }
        // Returns false if the contact was not added successfully
        return false;

    }

    // Method to find the contact by id
    public Contact getContact(String id) {
        for (Contact contactObject : contacts) {
            // Checks if there is a contact with that id
            if (contactObject.getID().equals(id)) {
                return contactObject;
            }
        }
        return null;
    }

    // Method to delete a contact by id
    public boolean deleteContact(String id) {
        Contact contact = getContact(id);
        if (contact != null) {
            contacts.remove(contact);
            return true;
        }
        ;
        return false;
    }

    // Method to validate the field is not null or exceeds the length
    public boolean isValid(String field, int maxLength) {
        return !(field.equals("") || field.length() > maxLength);
    }

    // Method to update and check the validity of the fields
    public boolean updateContact(String id, String firstName, String lastName, String phone, String address) {

        // Gets the contact
        Contact contact = getContact(id);

        if (
            isValid(lastName, 10) &&
            isValid(firstName, 10) &&
            phone.length() == 10 &&
            isValid(address, 30)) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhone(phone);
            contact.setAddress(address);
            return true;
        }


        return false;
    }

}