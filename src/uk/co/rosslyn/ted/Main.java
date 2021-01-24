package uk.co.rosslyn.ted;

import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //create a Bank instance
        Bank HSBC = new Bank("HSBC");
        HSBC.getBankName();
        //create branch instance
        Branch dunfermline = new Branch("Dunfermline");
        Branch edinburgh = new Branch("Edinburgh");

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
                    //add a Branch
                    System.out.println("Existing Branches are " + HSBC.getBranches());
                    System.out.print("Please enter the name of the new Branch: ");
                    String newBranchName1 = scanner.nextLine();
                    System.out.println("A new Branch has been added in " + newBranchName1);
                    HSBC.addBranch(newBranchName1);
                    System.out.println("Existing Branches are now " + HSBC.getBranches());
                    break;
                case 2:
                    //list customers and transactions, if needed
                    System.out.println("Please choose a branch: " + HSBC.getBranches());
                    String branchName2 = scanner.nextLine();
                    System.out.println("Do you wish to see all the transactions too? Enter 'yes' or 'no'");
                    String response2 = scanner.nextLine();
                    HSBC.listCustomers(branchName2, response2.equals("yes"));
                    break;
                case 3:
                    //search for a customer STILL TO DO
                    System.out.println("Please choose a branch: " + HSBC.getBranches());
                    String branchName3 = scanner.nextLine();
                    System.out.println("Please enter the customer name: ");
                    String customerName3 = scanner.nextLine();

                    break;
                case 4:
                    //add new Customer
                    System.out.println("Please choose a branch: " + HSBC.getBranches());
                    String branchName4 = scanner.nextLine();
                    System.out.println("Please enter the customer name: ");
                    String customerName4 = scanner.nextLine();
                    System.out.println("Please enter the amount: ");
                    double amount4 = scanner.nextDouble();

                    HSBC.addCustomer(branchName4, customerName4, amount4);
                    System.out.println("New Customer " + customerName4 + " deposited " + amount4 + " in the " + branchName4 + " Branch." );
                    break;
                case 5:
                    //add a Transaction.  Validation to be added!
                    System.out.println("Please enter the branch name: ");
                    String branchName5 = scanner.nextLine();
                    System.out.println("Please enter the customer name: ");
                    String customerName5 = scanner.nextLine();
                    System.out.println("Please enter the amount: ");
                    double amount5 = scanner.nextDouble();

                    HSBC.addCustomerTransaction(branchName5, customerName5, amount5);
                    System.out.println(amount5 + " deposited in " + customerName5 + "'s account");
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress ");   // new line
        System.out.println("\t 0 - To print choice of options.");    // tab
        System.out.println("\t 1 - To add a Branch");
        System.out.println("\t 2 - To list all Branch customers");
        System.out.println("\t 3 - To search for a customer");
        System.out.println("\t 4 - To add a new Customer");
        System.out.println("\t 5 - To add a customer transaction");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void searchCustomer(String customerName) {
       // System.out.print("Please enter customer name: ");
        //String customerName3 = scanner.nextLine();



       if (customerName != null) {
            System.out.println("Found " + customerName);
        } else {
            System.out.println(customerName + " does not have an account at this branch");
        }
    }
}


       /* //test adding when branch doesn't' exist
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


