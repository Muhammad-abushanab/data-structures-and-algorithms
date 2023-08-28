/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package linkedlist;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        int choice = 0;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            handleMainMenuChoice(choice,linkedList,scanner);
        } while (choice != 10);

        scanner.close();
    }
    private static void displayMainMenu() {
        System.out.println("Hello to Linked List program");
        System.out.println("1- Insert");
        System.out.println("2- Include");
        System.out.println("3- Insert Before");
        System.out.println("4- Insert After");
        System.out.println("5- Delete");
        System.out.println("6- Append");
        System.out.println("7- Kth From End");
        System.out.println("8- Print");
        System.out.println("9- ZipLists");
        System.out.println("10- Exit");
        System.out.print("Enter your choice: ");
    }
    private static void displayZipListsMenu() {
        System.out.println("ZipLists Menu");
        System.out.println("****************************");
        System.out.println("Please note that to merge the lists");
        System.out.println("You must insert a list from the main menu");
        System.out.println("This menu will create another list");
        System.out.println("if you have not inserted into the first list");
        System.out.println("no problem the program will resume but the value you will receive is the same as you insert");
        System.out.println("****************************");
        System.out.println("1- insert");
        System.out.println("2- print");
        System.out.println("3- zip");
        System.out.println("4- Back to Main Menu");
        System.out.print("Enter your sub-choice: ");
    }
    private static void handleMainMenuChoice(int choice,LinkedList linkedList, Scanner scanner){
        switch (choice) {
            case 1:
                System.out.print("Enter value to insert: ");
                int value = scanner.nextInt();
                linkedList.insert(value);
                break;

            case 2:
                System.out.print("Enter value to check: ");
                int checkValue = scanner.nextInt();
                boolean includes = linkedList.includes(checkValue);
                if (includes) {
                    System.out.println("Value " + checkValue + " exists");
                } else {
                    System.out.println("Value " + checkValue + " does not exists");
                }
                break;
            case 3:
                System.out.print("Enter value to insert: ");
                int valueToInsertBefore = scanner.nextInt();
                System.out.print("Enter value before which to insert: ");
                int beforeValue = scanner.nextInt();
                linkedList.insertBefore(valueToInsertBefore, beforeValue);
                break;

            case 4:
                System.out.print("Enter value to insert: ");
                int valueToInsert = scanner.nextInt();
                System.out.print("Enter value after which to insert: ");
                int afterValue = scanner.nextInt();
                linkedList.insertAfter(valueToInsert, afterValue);
                break;

            case 5:
                System.out.println("Enter value to delete");
                int deleteValue = scanner.nextInt();
                linkedList.delete(deleteValue);
                break;
            case 6:
                System.out.println("Enter value to append");
                int valueAppend = scanner.nextInt();
                linkedList.append(valueAppend);
                break;
            case 7:
                System.out.println("Enter K value");
                int kValue = scanner.nextInt();
                try {
                    System.out.println("Value is " + linkedList.kthFromEnd(kValue));
                } catch (IllegalArgumentException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                } catch (NullPointerException e) {
                    System.out.println("A Error occurred: " + e.getMessage() + "\nHint : This LinkedList is zeroBased size");
                }
                break;
            case 8:
                System.out.println("Linked List: " + linkedList);
                break;
            case 9:
                zipListsSubMenu(linkedList, scanner);
            case 10:
                System.out.println("Exiting ...");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    private static void zipListsSubMenu(LinkedList linkedList, Scanner scanner) {
        LinkedList newList = new LinkedList();
        int subChoice = 0;
        do {
            displayZipListsMenu();
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int val = scanner.nextInt();
                    newList.insert(val);
                    break;
                case 2:
                    System.out.println("Linked List: " + newList);
                    break;
                case 3:
                    LinkedList merged = new LinkedList();
                    System.out.println("MergedLinkedList ->" + merged.zipLists(linkedList, newList).toString());
                    break;
                case 4:
                    System.out.println("Back To Main Menu");
                    break;
                default:
                    System.out.println("Invalid sub-choice");
                    break;
            }
        } while (subChoice != 4);
    }
}
