package uk.co.rosslyn.ted;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //create a bank instance
        Bank HSBC = new Bank("HSBC");
        HSBC.getBankName();
        //create branch instance
        Branch dunfermline = new Branch("Dunfermline");
        Branch edinburgh = new Branch("Edinburgh");

        //create a branch instance
        HSBC.addBranch("Dunfermline");
        HSBC.addBranch("Edinburgh");
        //add customers
        HSBC.addCustomer("Dunfermline", "Grant", 2134.56);
        System.out.println();
        HSBC.addCustomer("Edinburgh", "Stewart", 1212.99);
        System.out.println();
        HSBC.addCustomer("Dunfermline", "Rory", 3423.01);
        System.out.println();
        HSBC.addCustomer("Dunfermline", "Peter", 654.78);
        System.out.println();


        //add more transactions
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -123.67);
        System.out.println();
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -10.99);
        System.out.println();
        HSBC.addCustomerTransaction("Edinburgh", "Stewart", -5.56);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -15.56);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -29.99);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Grant", -55.54);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Grant", 17.68);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -27.68);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -222.00);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Rory", -3.45);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Peter", -234.00);
        System.out.println();
        HSBC.addCustomerTransaction("Dunfermline", "Peter", 345.67);
        System.out.println();

        HSBC.listCustomers("Dunfermline", false);
        System.out.println();
        HSBC.listCustomers("Dunfermline", true);
        System.out.println();
        HSBC.listCustomers("Edinburgh", false);
        System.out.println();
        HSBC.listCustomers("Edinburgh", true);
        System.out.println();
        HSBC.listCustomersBalances("Dunfermline");
        System.out.println();
        HSBC.listCustomersBalances("Edinburgh");
        System.out.println();

        //test adding when branch doesn't' exist
        if (!HSBC.addCustomer("Glasgow", "David", 34.99)) {
            System.out.println("Glasgow branch doesn't exist!");
        }
        //test adding branch that already exists
        if (!HSBC.addBranch("Dunfermline")) {
            System.out.println("Branch already exists");
        }
        //add transaction to customer who doesn't exist
        if (!HSBC.addCustomerTransaction("Edinburgh", "Jimmy", 123.45)) {
            System.out.println("Customer does not exist");
        }
        //test adding customer who already exists
        if (!HSBC.addCustomer("Dunfermline", "Grant", 34.99)) {
            System.out.println("Customer already exists!");
            System.out.println();
            //get a customer's balance
            HSBC.listCustomerBalance("Dunfermline", "Grant");
            System.out.println();
        }
        //menu to access information
        boolean quit = false;
        int choice;
        //for submenu
        printInstructions();
        while (!quit) {
            //scanner.nextLine();
            System.out.println("Enter your main menu choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    //add a Branch
                    System.out.println("Existing Branches are " + HSBC.getBranches());
                    System.out.print("Please enter the name of the new Branch: ");
                    scanner.nextLine();
                    String branchName = scanner.nextLine();
                    HSBC.addBranch(branchName);
                    System.out.println("Existing Branches are now " + HSBC.getBranches());
                    break;
                case 2:
                    //list customers and transactions, if needed
                    System.out.println("Please choose a branch: " + HSBC.getBranches());
                    scanner.nextLine();
                    String branchName2 = scanner.nextLine();
                    System.out.println("Do you wish to see all the transactions too? Enter 'yes' or 'no'");
                    String response2 = scanner.nextLine();
                    HSBC.listCustomers(branchName2, response2.equals("yes"));
                    break;
                case 3:
                    //Get customer balances
                    System.out.println("Please choose a branch: " + HSBC.getBranches());
                    scanner.nextLine();
                    String branchName3 = scanner.nextLine();
                    HSBC.listCustomersBalances(branchName3);
                    break;
                case 4:
                    //add new Customer
                    System.out.println("Please choose a branch: " + HSBC.getBranches());
                    scanner.nextLine();
                    String branchName4 = scanner.nextLine();
                    System.out.println("Please enter the customer name: ");
                    String customerName4 = scanner.nextLine();
                    System.out.println("Please enter the amount: ");
                    double amount4 = scanner.nextDouble();
                    HSBC.addCustomer(branchName4, customerName4, amount4);
                    break;
                case 5:
                    //Customer balance, deposit/ withdrawal
                    printCustomerSubmenu();
                    boolean goBack = false;
                    int menuChoice;
                    // if (!goBack) {
                    while (!goBack) {
                        System.out.println("Enter your submenu choice: ");
                        menuChoice = scanner.nextInt();
                        // scanner.nextLine();
                        switch (menuChoice) {
                            case 0:
                                printCustomerSubmenu();
                                break;
                            case 1:
                                //balance enquiry
                                System.out.println("Please enter the branch name: ");
                                scanner.nextLine();
                                String branchName1 = scanner.nextLine();
                                System.out.println("Please enter the customer name: ");
                                String customerName1 = scanner.nextLine();

                                //scanner.nextLine();
                                // scanner.nextLine();
                                HSBC.listCustomerBalance(branchName1, customerName1);
                                // HSBC.listCustomerBalance("Dunfermline", "Grant");
                                //go back to case 5 in main menu:
                                //menuChoice = 0;
                                break;
                            case 2:
                                //make a deposit
                                System.out.println("Please enter the branch name: ");
                                scanner.nextLine();
                                String branchName52 = scanner.nextLine();
                                System.out.println("Please enter the customer name: ");
                                String customerName52 = scanner.nextLine();
                                System.out.println("Please enter the amount: ");
                                double amount52 = scanner.nextDouble();
                                HSBC.addCustomerTransaction(branchName52, customerName52, amount52);
                                break;
                            case 3:
                                //make a withdrawal
                                System.out.println("Please enter the branch name: ");
                                scanner.nextLine();
                                String branchName53 = scanner.nextLine();
                                System.out.println("Please enter the customer name: ");
                                String customerName53 = scanner.nextLine();
                                System.out.println("Please enter the amount: ");
                                double amount53 = scanner.nextDouble();
                                HSBC.addCustomerTransaction(branchName53, customerName53, -amount53);
                                break;
                            case 4:
                                //back to main menu
                                goBack = true; //exit the inner while loop
                                break;
                        }//inner switch
                    }//inner while
                    // break;
                case 6:
                    if (choice == 6) {
                        quit = true;
                        break;
                    } else {
                        quit = false;
                        break;
                    }
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress ");   // new line
        System.out.println("\t 0 - To print choice of options.");    // tab
        System.out.println("\t 1 - To add a Branch");
        System.out.println("\t 2 - To list all Branch customers");
        System.out.println("\t 3 - To get customer balances for a branch");
        System.out.println("\t 4 - To add a new Customer");
        System.out.println("\t 5 - To add a customer transaction");
        System.out.println("\t 6 - To quit the application.");
        System.out.println();
    }

    private static void printCustomerSubmenu() {
        System.out.println("\t\t\nPress ");   // new line
        System.out.println("\t\t 0 - To print choice of options.");    // tab
        System.out.println("\t\t 1 - For a balance enquiry");
        System.out.println("\t\t 2 - To make a deposit");
        System.out.println("\t\t 3 - To make a withdrawal");
        System.out.println("\t\t 4 - To return to the main menu");
        System.out.println();
    }
}
