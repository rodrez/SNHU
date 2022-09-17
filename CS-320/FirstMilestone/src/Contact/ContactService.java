package Contact;

import java.util.ArrayList; // used to store the contacts 
import java.util.List;
import java.util.UUID; // used to generate an unique id

public class ContactService {

    private String uniqueId = UUID.randomUUID().toString().substring( // Generates a random ID with a length of 10
            0, Math.min(toString().length(), 10));
    private List<Contact> contactList = new ArrayList<>();

    // Method to Creates a new contact
    public void createContact(String firstName, String lastName, String phone,
            String address) {
        Contact contact = new Contact(createUniqueId(), firstName, lastName, phone, address);
        contactList.add(contact);
    }

    // Method to delete a contact
    public void deleteContact(String id) throws Exception {
        contactList.remove(findContact(id));
    }

    // Method to update the first name
    public void updateFirstName(String id, String firstName) throws Exception {
        findContact(id).setFirstName(firstName);
    }

    // Method to update the last name
    public void updateLastName(String id, String lastName) throws Exception {
        findContact(id).setLastName(lastName);
    }

    // Method to update phone
    public void updatePhone(String id, String phoneNumber)
            throws Exception {
        findContact(id).setPhoneNumber(phoneNumber);
    }

    // Method to update address
    public void updateAddress(String id, String address) throws Exception {
        findContact(id).setAddress(address);
    }

    // All the contacts
    protected List<Contact> getContactList() {
        return contactList;
    }

    // Method to create an unique id
    private String createUniqueId() {
        return uniqueId;
    }

    private Contact findContact(String id) throws Exception {
        int index = 0;

        // Loops through the contact list to get a contact by id
        while (index < contactList.size()) {
            if (id.equals(contactList.get(index).getID())) {
                return contactList.get(index);
            }
            index++;
        }
        throw new Exception("The Task does not exist!");
    }
}

//package contact;
//
//import java.util.ArrayList;
//
//public class ContactService {
////will contain our list of contacts
//
//private ArrayList<Contact> contacts;
//
//public ContactService()
//{
////beginning call for the array list
//contacts = new ArrayList<>();
//}
//
////need to have an add contact, remove contact and update contact feature
////set add contact to have all values
//public boolean addContact(Contact contact){
//boolean contactAlready= false;
////run through all the contacts in the list made
//for (Contact contactList:contacts)
//{
////test to see if already a contact
////if so make contactAlready true
//if (contactList.equals(contact))
//{
//contactAlready = true;
//}
//}
////if not a contact add it as one
//if (!contactAlready)
//{
//contacts.add(contact);
////after adding is now true
//return true;
//}
//else
//{
//return false;
//}
//}
//
////delete needed via contactID
//public boolean deleteContact(String contactID)
//{
////run through list of contacts
//for (Contact contactList:contacts)
//{
////if equals to contactID will remove and return
//if (contactList.getContactID().equals(contactID))
//{
////remove and return true
//contacts.remove(contactList);
//return true;
//}
//}
////else return false
//return false;
//}
//
////update is trickiest due to needing to make sure still fits parameters
////nothing means no change
//public boolean updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address)
//{
////run through loop again
//for (Contact contactList:contacts)
//{
////if contactID matches, run through each with making sure not "" and meets requirements
////then return true as it did equal update.
//if (contactList.getContactID().equals(contactID))
//{
//if(!firstName.equals("") && !(firstName.length()>10))
//{
//contactList.setFirstName(firstName);
//}
//if(!lastName.equals("") && !(lastName.length()>10))
//{
//contactList.setFirstName(lastName);
//}
//if(!phoneNumber.equals("") && (phoneNumber.length()==10))
//{
//contactList.setFirstName(phoneNumber);
//}
//if(!address.equals("") && !(address.length()>30))
//{
//contactList.setFirstName(address);
//}
//return true;
//}
//}
////else return false
//return false;
//}
//}
//
//
//
//
//
