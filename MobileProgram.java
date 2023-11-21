import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}

class MobilePhone {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    public MobilePhone() {
        this.contacts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    private void printMenu() {
        System.out.println("\nOptions:");
        System.out.println("1. Quit");
        System.out.println("2. Print list of contacts");
        System.out.println("3. Add a new contact");
        System.out.println("4. Update an existing contact");
        System.out.println("5. Remove a contact");
        System.out.println("6. Search/find a contact");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        boolean quit = false;
        int choice;

        while (!quit) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    quit = true;
                    System.out.println("Exiting the program...");
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    searchContact();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private void printContacts() {
        System.out.println("\nContact List:");
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber());
        }
    }

    private void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();

        if (findContact(name) == null) {
            Contact newContact = Contact.createContact(name, phoneNumber);
            contacts.add(newContact);
            System.out.println("Contact added: " + name + ", " + phoneNumber);
        } else {
            System.out.println("Contact already exists with name: " + name);
        }
    }

    private void updateContact() {
        System.out.print("Enter contact name to update: ");
        String name = scanner.nextLine();
        Contact existingContact = findContact(name);

        if (existingContact != null) {
            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            existingContact = Contact.createContact(name, newPhoneNumber);
            System.out.println("Contact updated: " + name + ", " + newPhoneNumber);
        } else {
            System.out.println("Contact not found with name: " + name);
        }
    }

    private void removeContact() {
        System.out.print("Enter contact name to remove: ");
        String name = scanner.nextLine();
        Contact existingContact = findContact(name);

        if (existingContact != null) {
            contacts.remove(existingContact);
            System.out.println("Contact removed: " + name);
        } else {
            System.out.println("Contact not found with name: " + name);
        }
    }

    private void searchContact() {
        System.out.print("Enter contact name to search: ");
        String name = scanner.nextLine();
        Contact existingContact = findContact(name);

        if (existingContact != null) {
            System.out.println("Contact found: " + name + ", " + existingContact.getPhoneNumber());
        } else {
            System.out.println("Contact not found with name: " + name);
        }
    }

    private Contact findContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }
}

public class MobileProgram{
    public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone();
        mobilePhone.start();
    }
}
