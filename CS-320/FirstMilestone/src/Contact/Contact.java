package Contact;

import java.util.UUID;

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

  protected void setPhone(String phone) {
    String regex = "[\\d]+"; // Only digits
   if (!phone.matches(regex)) { // Check if phone number is only digits
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

  protected void setUniqueId() {
    String uuid = UUID.randomUUID().toString(); // Set contact ID
    this.id = uuid.substring(uuid.length() - 16);
  }

  // Simplify the code above by using the constructor below
  public Contact(String firstName, String lastName, String phone, String address) {
    setUniqueId();
    setFirstName(firstName);
    setLastName(lastName);
    setPhone(phone);
    setAddress(address);

    System.out.printf("%s",this.toString());
  }

  @Override
  public String toString() {
    return "Contact: ID=" + id + ", firstName=" + firstName + ", lastName=" + lastName
        + ", phone=" + phone + ", address=" + address;
  }
}
