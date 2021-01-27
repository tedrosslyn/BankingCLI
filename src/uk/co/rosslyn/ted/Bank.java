package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    private ArrayList<Branch> branches;
    //private ArrayList<Branch> branches = new ArrayList<>(); //redundant initialiser

    public Bank(String bankName) {
        this.bankName = bankName;
        //initialise the AL
        this.branches = new ArrayList<>();
    }

    public String getBankName() {
        System.out.println(bankName);
        return bankName;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) { //ie branch name doesn't already exist
            this.branches.add(new Branch(branchName));
            return true;
        }
        System.out.println("This Branch already exists");
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
            //return branch.addTransaction(customerName, amount); //ie calling branch code for a new customer
            return branch.addTransaction(customerName, amount);
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
            for (Customer allCustomers : branchCustomers) {
                String custName = allCustomers.getCustomerName();
                System.out.println("Customer: " + custName);
                if (showTransactions) {
                    System.out.println(custName + "'s transactions : "); //+ allCustomers.getCustTrans()
                    ArrayList<Double> transactions = allCustomers.getCustTrans();
                    // for (Double allTransactions : transactions) { //don't need the 2nd for loop
                    System.out.println(allCustomers.getCustTrans());
                    //}
                }
            }
            return true;
        } else return false;
    }

    public boolean listCustomersBalances(String branchName) {
        //test if branch is already on file
        Branch branch = findBranch(branchName);
        if (branch != null) { //can process
            System.out.println("Customers' balances for " + branch.getBranchName() + " branch:"); //could have just used branchName parameter
            //get a list of customer records:
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            //print them to screen - use enhanced for loop for (type variableName : arrayName)
            for (Customer allCustomers : branchCustomers) {
                double customersBalance = allCustomers.getBalance();
                System.out.println(allCustomers.getCustomerName() + "'s Balance: " + customersBalance);
            }
            return true;
        } else return false;
    }

    public boolean listCustomerBalance(String branchName, String customerName) {
        //test if branch is already on file
        Branch branch = findBranch(branchName);
        if (branch != null) { //can process
            System.out.println("Balance for " + customerName + " at " + branch.getBranchName() + " branch:");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            //print them to screen - use enhanced for loop for (type variableName : arrayName)
            for (Customer allCustomers : branchCustomers) {
                if (allCustomers.getCustomerName().equals(customerName) ) {
                    //find the customerName you want the balance for
                    double customerBalance = allCustomers.getBalance();
                    System.out.println(allCustomers.getCustomerName() + "'s Balance: " + customerBalance);
                }
            }
            return true;
        } else return false;
    }
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }


}//close class

