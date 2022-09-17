package Contact;

public class Contact {
  private String firstName;
  private String lastName;
  private String phone;
  private String address;
  private String id;

  private static final int GENERAL_LENGTH = 10;
  private static final byte CONTACT_ADDRESS_LENGTH = 30;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public String getAddress() {
    return address;
  }

  public String getID() {
    return id;
  }

  // Setters and validation
  // Update one or more contact fields
  protected void setFirstName(String firstName) {
    if (firstName == null) {
      throw new IllegalArgumentException("First Name must not be empty");
    } else if (firstName.length() > GENERAL_LENGTH) {
      throw new IllegalArgumentException("First Name must not exceed " +
          GENERAL_LENGTH + " characters");
    }
    this.firstName = firstName;

  }

  protected void setLastName(String lastName) {
    if (lastName == null) { // Last name must not be empty
      throw new IllegalArgumentException("Last Name must not be empty"); // Throw exception
    } else if (lastName.length() > GENERAL_LENGTH) { // Last name must not exceed 10 characters
      throw new IllegalArgumentException("Last Name must not exceed " + GENERAL_LENGTH + " characters"); // Throw
      // exception
    }
    this.lastName = lastName;

  }

  protected void setPhoneNumber(String phone) {
    String regex = "[\\d]+"; // Only digits

    // Check if phone number is valid
    if (phone == null) {
      throw new IllegalArgumentException("Phone number must not be empty.");
    } else if (phone.length() != GENERAL_LENGTH) { // Check if phone number is 10 digits
      throw new IllegalArgumentException(
          "Phone number length must not exceed " +
              GENERAL_LENGTH + " digits."); // Throw exception if phone number is not 10 digits
    } else if (!phone.matches(regex)) { // Check if phone number is only digits
      throw new IllegalArgumentException( // Throw exception if phone number is not only digits
          "Please enter a valid phone number. Only digits are allowed.");
    }

    this.phone = phone; // Set phone number

  }

  protected void setAddress(String address) {
    if (address == null) { // Check if address is null
      throw new IllegalArgumentException("Address must not be empty"); // Throw exception if address is null
    } else if (address.length() > CONTACT_ADDRESS_LENGTH) { // Check if address is too long
      throw new IllegalArgumentException("Address must not be longer than " + // Throw exception if address is too long
          CONTACT_ADDRESS_LENGTH +
          " characters");
    }
    this.address = address; // Set address

  }

  protected void setContactId(String contactId) {
    if (contactId == null) { // Check if contact ID is null
      throw new IllegalArgumentException("Contact ID must not be empty"); // Throw exception if contact ID is null
    } else if (contactId.length() > GENERAL_LENGTH) { // Check if contact ID is too long
      throw new IllegalArgumentException("Contact ID must not be longer than " + // Throw exception if contact ID is too
      // long
          GENERAL_LENGTH + " characters");
    }
    this.id = contactId; // Set contact ID
  }

  // Simplify the code above by using the constructor below
  Contact(String id, String firstName, String lastName, String phone, String address) {
    setContactId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setPhoneNumber(phone);
    setAddress(address);
  }

  @Override
  public String toString() {
    return "Contact: ID=" + id + ", firstName=" + firstName + ", lastName=" + lastName
        + ", phone=" + phone + ", address=" + address;
  }
}
