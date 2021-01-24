package uk.co.rosslyn.ted;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //create a Bank instance
        Bank HSBC = new Bank("HSBC");
        HSBC.getBankName();
        //create branch instance
        Branch dunfermline = new Branch("Dunfermline");

        HSBC.addBranch("Dunfermline");
        HSBC.addBranch("Edinburgh");
        //add customers
        HSBC.addCustomer("Dunfermline", "Grant", 2134.56);
        HSBC.addCustomer("Edinburgh", "Stewart", 1212.99);
        HSBC.addCustomer("Dunfermline", "Rory", 3423.01);
        HSBC.addCustomer("Dunfermline", "Peter", 654.78);

        //add more transactions
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -123.67);
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -10.99);
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -5.56);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -15.56);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -29.99);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -55.54);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", 17.68);
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -27.68);
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -222.00);
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -3.45);
        HSBC.addCustomerTransaction("Dunfermline", "Peter", -234.00);
        HSBC.addCustomerTransaction("Dunfermline", "Peter", 345.67);



        //menu to access information
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    HSBC.listCustomers("Dunfermline",false);
                    break;
                case 2:
                    HSBC.listCustomers("Dunfermline",true);
                    break;
                case 3:
                    HSBC.listCustomers("Edinburgh",false);
                    break;
                case 4:
                    HSBC.listCustomers("Edinburgh",true);
                    break;
                case 5:
                    //addTransaction();
                    System.out.print("Please enter the branch name: ");
                    String branchName = scanner.nextLine();
                    System.out.println("Please enter the customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.println("Please enter the amount: ");
                    double amount = scanner.nextDouble();

                    HSBC.addCustomerTransaction(branchName, customerName, amount);
                    System.out.println(amount + " deposited in " + customerName + "'s account");
                    break;
                case 6:
                    quit = true;
                    break;

            }
        }


    }

    private static void addTransaction() {
        System.out.print("Please enter the branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Please enter the customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Please enter the amount: ");
        double amount = scanner.nextDouble();


    }


    private static void printInstructions() {
        System.out.println("\nPress ");   // new line
        System.out.println("\t 0 - To print choice of options.");    // tab
        System.out.println("\t 1 - To list all Dunfermline Branch customers");
        System.out.println("\t 2 - To list all Dunfermline Branch customers with transactions");
        System.out.println("\t 3 - To list all Edinburgh Branch customers");
        System.out.println("\t 4 - To list all Edinburgh Branch customers with transactions");
        System.out.println("\t 5 - To list the branch Customers");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the item: ");
        //groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Please enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
       // groceryList.modifyGroceryItem(itemNo - 1, newItem);
    }

    public static void removeItem() {
        System.out.print("Please enter item number: ");
        int itemNo = scanner.nextInt();
        scanner.nextLine();
       // groceryList.removeGroceryItem(itemNo - 1);
    }

    public static void searchCustomer() {
        System.out.print("Please enter customer name: ");
        String customerName = scanner.nextLine();
        if (customerName != null) {
            System.out.println("Found " + customerName);
        } else {
            System.out.println(customerName + " does not have an account at this branch");
        }
    }
}




        /*//create a Bank instance
        Bank HSBC = new Bank("HSBC");
        HSBC.getBankName();
        //create a branch instance
        HSBC.addBranch("Dunfermline");
        HSBC.addBranch("Edinburgh");
        //add customers
        HSBC.addCustomer("Dunfermline", "Grant", 2134.56);
        HSBC.addCustomer("Edinburgh", "Stewart", 1212.99);
        HSBC.addCustomer("Dunfermline", "Rory", 3423.01);
        HSBC.addCustomer("Dunfermline", "Peter", 654.78);

        //add more transactions
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -123.67);
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -10.99);
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -5.56);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -15.56);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -29.99);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -55.54);
        HSBC.addCustomerTransaction("Dunfermline", "Grant", 17.68);
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -27.68);
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -222.00);
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -3.45);
        HSBC.addCustomerTransaction("Dunfermline", "Peter", -234.00);
        HSBC.addCustomerTransaction("Dunfermline", "Peter", 345.67);

        HSBC.listCustomers("Dunfermline",false);
        System.out.println();
        HSBC.listCustomers("Dunfermline",true);
        System.out.println();
        HSBC.listCustomers("Edinburgh",false);
        System.out.println();
        HSBC.listCustomers("Edinburgh",true);

        //test adding when branch doesn't' exist
        if(!HSBC.addCustomer("Glasgow", "David", 34.99)){
            System.out.println("Glasgow branch doesn't exist!");
        }
        //test adding branch that already exists
        if(!HSBC.addBranch("Dunfermline")) {
            System.out.println("Branch already exists");
        }
        //add transaction to customer who doesn't exist
        if(!HSBC.addCustomerTransaction("Edinburgh", "Jimmy", 123.45 )) {
            System.out.println("Customer does not exist");
        }
        //test adding customer who already exists
        if(!HSBC.addCustomer("Dunfermline", "Grant", 34.99)){
            System.out.println("Customer already exists!");
        }*/


