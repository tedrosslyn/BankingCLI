package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.branchName = name;
        //initialise the AL in the constructor - create empty AL
        this.customers = new ArrayList<>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initAmount));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        //for(int i = 0; i < this.customers.size(); i++) {
        for (Customer confirmedCustomer : this.customers) {
            if (confirmedCustomer.getCustomerName().equals(customerName)) {
                return confirmedCustomer;
            }
        }
        return null;
    }
} //close class



