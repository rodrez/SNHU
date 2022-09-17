package Contact;

import java.util.ArrayList;

public class ContactService {
//will contain our list of contacts

    private final ArrayList<Contact> contacts;

    public ContactService() {
//beginning call for the array list
        contacts = new ArrayList<>();
    }

    //need to have an add contact, remove contact and update contact feature
//set add contact to have all values
    public boolean addContact(Contact contact) {
        boolean contactAlready = false;
//run through all the contacts in the list made
        for (Contact contactList : contacts) {
//test to see if already a contact
//if so make contactAlready true
            if (contactList.equals(contact)) {
                contactAlready = true;
                break;
            }
        }
//if not a contact add it as one
        if (!contactAlready) {
            contacts.add(contact);
//after adding is now true
            return true;
        } else {
            return false;
        }
    }

    //delete needed via contactID
    public boolean deleteContact(String contactID) {
//run through list of contacts
        for (Contact contactList : contacts) {
//if equals to contactID will remove and return
            if (contactList.getContactID().equals(contactID)) {
//remove and return true
                contacts.remove(contactList);
                return true;
            }
        }
//else return false
        return false;
    }

    //update is trickiest due to needing to make sure still fits parameters
//nothing means no change
    public boolean updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
//run through loop again
        for (Contact contactList : contacts) {
//if contactID matches, run through each with making sure not "" and meets requirements
//then return true as it did equal update.
            if (contactList.getID().equals(contactID)) {
                if (!firstName.equals("") && !(firstName.length() > 10)) {
                    contactList.setFirstName(firstName);
                }
                if (!lastName.equals("") && !(lastName.length() > 10)) {
                    contactList.setFirstName(lastName);
                }
                if (!phone.equals("") && (phoneNumber.length() == 10)) {
                    contactList.setFirstName(phoneNumber);
                }
                if (!address.equals("") && !(address.length() > 30)) {
                    contactList.setFirstName(address);
                }
                return true;
            }
        }
//else return false
        return false;
    }
}