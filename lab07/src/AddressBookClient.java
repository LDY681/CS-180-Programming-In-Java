import java.util.Scanner;

/**
 * The AddressBookClient simulates the functionality of the AddressBook.
 */
public class AddressBookClient {
	
    /**
     * Command line interface for simulating the AddressBook.
     * 
     * @param args Unused
     */
    public static void main(String[] args) {
    	AddressBook ab = new AddressBook();
    	Scanner s = new Scanner(System.in);
	Contact c;
	String name, email;
	boolean added;
	long number;
	int selection = 0;
		
	System.out.println("Welcome to the Address Book!");
		
	do {
            System.out.println("Select an option from the menu below:");
	    System.out.println("1 - Add a new Contact");
	    System.out.println("2 - Remove an existing Contact");
	    System.out.println("3 - Get details about a Contact");
	    System.out.println("4 - Print Address Book");
	    System.out.println("5 - Exit");
	    selection = s.nextInt();
			
	    if (selection == 1) {
		int subSelection = 0;
		do {
		    System.out.println("Select an option below: ");
		    System.out.println("1 - New Contact with name");
		    System.out.println("2 - New Contact with name and number");
		    System.out.println("3 - New Contact with name, number, and address");
		    subSelection = s.nextInt();
		} while (subSelection < 1 && subSelection > 3);
		s.nextLine();
		System.out.println("Enter the name of the Contact to add/update: ");
		name = s.nextLine();
		if (subSelection == 1) {
		    added = ab.addContact(new Contact(name));
		} else if (subSelection == 2) {
		    System.out.println("Enter the number of the Contact: ");
		    number = s.nextLong();
		    added = ab.addContact(new Contact(name, number));
		} else {
		    System.out.println("Enter the number of the Contact: ");
		    number = s.nextLong();
		    System.out.println("Enter the address of the Contact: ");
		    s.nextLine();
		    email = s.nextLine();
		    added = ab.addContact(new Contact(name, number, email));
		}
		if (added) {
		    System.out.printf("%s was added to the Address Book.%n", name);
		} else {
		    System.out.printf("Information for existing Contact %s updated.%n", name);
		}
	    } else if (selection == 2) {
		System.out.println("Enter the name of the Contact you would like to remove:");
		s.nextLine();
		c = new Contact(s.nextLine());
		if (ab.removeContact(c)) {
		    System.out.printf("%s remove from the Address Book.%n", c.getName());
		} else {
		    System.out.printf("%s was not in the Address Book.%n", c.getName());
		}
	    } else if (selection == 3) {
		System.out.println("Enter the name of the Contact:");
		s.nextLine();
		name = s.nextLine();
		c = ab.getContactByName(name);
		if (c != null) {
		    System.out.printf("Name: %s%n", c.getName());
		    System.out.printf("Number: %d%n", c.getNumber());
		    System.out.printf("Address: %s%n", c.getAddress());
		} else {
		    System.out.printf("%s was not found in the Address Book.%n", name);
		}
	    } else if (selection == 4) {
		ab.printAddressBook();
	    } else if (selection != 5) {
		System.out.println("Invalid selection, try again.");
	    }
	    System.out.println();
	} while (selection != 5);
		
        s.close();
    }
}