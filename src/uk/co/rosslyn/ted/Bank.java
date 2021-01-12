package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Bank {

    private String branchName;
    private ArrayList<Branch> branches;
    //private ArrayList<Branch> branches = new ArrayList<>(); //redundant initialiser

    public Bank(String branchName) {
        this.branchName = branchName;
        //initialise the AL
        this.branches = new ArrayList<>();
        //this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) { //ie branch name doesn't already exist
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initTrans) {
        //test if branch is already on file
        Branch branch = findBranch(branchName);
        if (branch != null) { //can only add a customer if the branch name exists
            return branch.newCustomer(customerName, initTrans); //ie calling branch code for a new customer
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        //test if branch is already on file
        Branch branch = findBranch(branchName);
        if (branch != null) { //can only add a transaction if the branch name exists
            return branch.addTransaction(customerName, amount); //ie calling branch code for a new customer
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        //for(int i = 0; i < this.branches.size(); i++) {
        for (Branch confirmedBranch : this.branches) {
            if (confirmedBranch.getBranchName().equals(branchName)) {
                return confirmedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {  //true to see customers and transactions
        //test if branch is already on file
        Branch branch = findBranch(branchName);
        if (branch != null) { //can process
            System.out.println("Customers details for " + branch.getBranchName() + " branch:"); //could have just used branchName parameter
            //get a list of customer records:
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            //print them to screen - use enhanced for loop for (type variableName : arrayName)
            for(Customer allCustomers : branchCustomers) {
                String custName = allCustomers.getCustomerName();
                System.out.println("Customer: " + custName);
                if (showTransactions) {
                    System.out.println(custName + "'s transactions : " ); //+ allCustomers.getCustTrans()
                    ArrayList<Double> transactions = allCustomers.getCustTrans();
                   // for (Double allTransactions : transactions) { //don't need the 2nd for loop
                        System.out.println(allCustomers.getCustTrans());
                    //}
                }
            }
            return true;
        } else return false;
    }
}//close class

