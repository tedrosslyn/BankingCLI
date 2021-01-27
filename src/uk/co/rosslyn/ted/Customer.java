package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private ArrayList<Double> custTrans; // = new ArrayList<>();
    private double balance = 0.0;

    public Customer(String customerName, double initTrans) {
        this.customerName = customerName;
        this.custTrans = new ArrayList<>();
        addTransaction(initTrans);
        setBalance(initTrans);
    }

    public void addTransaction(double amount) {
        this.custTrans.add(amount);
        if (amount >= 0) {
            System.out.println(this.customerName + " has deposited " + amount);
        } else {
            System.out.println(this.customerName + " has withdrawn " + amount);
        }
        this.balance += amount;
        System.out.println(this.customerName + "'s new balance is " + (getBalance()));
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getCustTrans() {
        return custTrans;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}//close class


