package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private ArrayList<Double> custTrans; // = new ArrayList<>();
    private double balance =0.0;

    public Customer(String customerName, double initTrans) {
        this.customerName = customerName;
        this.custTrans = new ArrayList<>();
        addTransaction(initTrans);
    }
    //replace addTransaction with deposit and withdrawal methods
    public void addTransaction(double amount) {
        this.custTrans.add(amount);
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


    //need to figure ths out. Maybe start without threads first!
//replacing addTransaction with makeDeposit(double amount) and makeWithdrawal(double amount) and updating balance
    /*private synchronized void makeWithdrawal(double amount) {
        if (customer.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch(InterruptedException ex) {ex.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawl");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());*/

        //private synchronized void makeDeposit(double amount) {