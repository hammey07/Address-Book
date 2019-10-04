import java.util.ArrayList;
import java.util.Scanner;

class AddressBook {
    private static ArrayList<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        personList.add(new Person("John", "O'Sullivan", "0831835567", "5, Suir house"));
        System.out.println(personList);

        chooseOption();
    }

    private static void chooseOption() {
        Scanner sc = new Scanner(System.in);
        int selection;
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu : ");
            System.out.println("Type any number between 1 and 6 for selection");
            System.out.println("1)Create a new Contact Record");
            System.out.println("2)Remove a Contact Record");
            System.out.println("3)Edit a Contact Record");
            System.out.println("4)Get Specific Contact Record information");
            System.out.println("5)List all Contacts by Firstname");
            System.out.println("6)List all Contacts by Lastname");
            System.out.println("7)Exit");
            selection = sc.nextInt();
            switch (selection) {
                case 1: //ADD A CONTACT
                    sc = new Scanner(System.in);
                    System.out.println("Enter Contact Firstname: ");
                    String firstname = sc.nextLine();
                    System.out.println("Enter Contact Lastname: ");
                    String lastname = sc.nextLine();
                    System.out.println("Enter Contact Phone number: ");
                    String phone = sc.nextLine();
                    System.out.println("Enter Contact Address: ");
                    String address = sc.nextLine();
                    System.out.println("Do you want to save this contact to address book? Type Yes / No");
                    Scanner sc1 = new Scanner(System.in);
                    String input = sc1.next();
                    if (input.equalsIgnoreCase("yes")) {
                        personList.add(new Person(firstname, lastname, phone, address));
                        System.out.println("Details saved");
                    } else if (input.equalsIgnoreCase("no")) {
                        System.out.println("Details Discarded");
                    }
                    break;

                case 2: // DELETE A RECORD
                    System.out.println("PLEASE SELECT CONTACT \"ID\" FROM LIST TO REMOVE");
                    personList.sort(new IdSort());
                    System.out.println("ID | FULL NAME");
                    for (Person person : personList) {
                        System.out.println(person.getId() + "  | " + person.getFirstname() + " " + person.getLastname());
                    }
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Please Enter Contact ID to remove");
                    int in = sc2.nextInt();
                    System.out.println("Are you sure you want to remove this contact? (Type Yes / No): \n" + checkArray(in));
                    String choice = sc2.next();
                    if (choice.equalsIgnoreCase("yes")) {
                        removeContact(in);

                    } else {
                        System.out.println("Contact NOT deleted");
                    }
                    exit = backToMenu();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    personList.sort(new FirstnameSort());
                    System.out.println("Sorting Contacts by Firstname");
                    System.out.println("ID | FULL NAME");

                    for (Person person : personList) {
                        System.out.println(person.getId() + "  | " + person.getFirstname() + " " + person.getLastname());
                    }
                    exit = backToMenu();
                    break;
                case 6:
                    personList.sort(new LastnameSort());
                    System.out.println("Sorting Contacts by Lastname");
                    System.out.println("ID | FULL NAME");
                    for (Person person : personList) {
                        System.out.println(person.getId() + "  | " + person.getFirstname() + " " + person.getLastname());
                    }
                    exit = backToMenu();
                    break;
                case 7:
                    exit = true;
                    break;
            }
        }


    }

    private static Person checkArray(int in) {
        int id = 0;
        for (Person p : personList) {
            if (p.getId() == in) {
                id = personList.indexOf(p);
            }
        }
        return personList.get(id);
    }


    private static void removeContact(int in) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == in) {
                personList.remove(i);
                System.out.println("Contact REMOVED successfully!");
                break;
            }
        }
    }

    private static boolean backToMenu() {
        boolean exit = false;
        System.out.println("Return to Main Menu? Type Yes / No");
        Scanner sc2 = new Scanner(System.in);
        if (sc2.next().
                equalsIgnoreCase("no"))
            exit = true;
        return exit;
    }
}
