import java.io.*;
import java.util.*;
class Contact {
    String name, phone, email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString() {
        return name + "," + phone + "," + email;
    }

    public static Contact fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Contact(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}
public class ContactManager {
    static final String FILE_NAME = "contacts.txt";
    static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        loadContacts(); // Load existing contacts from file
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n📞 Contact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addContact(scanner);
                case 2 -> viewContacts();
                case 3 -> editContact(scanner);
                case 4 -> deleteContact(scanner);
                case 5 -> {
                    saveContacts(); // Save contacts before exiting
                    System.out.println("📁 Contacts saved. Exiting...");
                }
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Load contacts from file
    private static void loadContacts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Contact contact = Contact.fromString(line);
                    if (contact != null) contacts.add(contact);
                }
            } catch (IOException e) {
                System.out.println("❌ Error loading contacts: " + e.getMessage());
            }
        }
    }

    // Save contacts to file
    private static void saveContacts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                bw.write(contact.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving contacts: " + e.getMessage());
        }
    }

    // Add a new contact
    private static void addContact(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("✅ Contact added successfully!");
    }

    // View all contacts
    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("📂 No contacts found.");
            return;
        }
        System.out.println("\n📋 Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            System.out.println((i + 1) + ". " + c.name + " | " + c.phone + " | " + c.email);
        }
    }

    // Edit a contact
    private static void editContact(Scanner scanner) {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to edit: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            System.out.print("Enter new Phone (leave blank to keep current): ");
            String phone = scanner.nextLine();
            System.out.print("Enter new Email (leave blank to keep current): ");
            String email = scanner.nextLine();

            Contact c = contacts.get(index);
            if (!name.isEmpty()) c.name = name;
            if (!phone.isEmpty()) c.phone = phone;
            if (!email.isEmpty()) c.email = email;

            System.out.println("✅ Contact updated!");
        } else {
            System.out.println("❌ Invalid contact number!");
        }
    }

    // Delete a contact
    private static void deleteContact(Scanner scanner) {
        viewContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("✅ Contact deleted successfully!");
        } else {
            System.out.println("❌ Invalid contact number!");
        }
    }
}
