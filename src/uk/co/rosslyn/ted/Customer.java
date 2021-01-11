package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Customer {

    private String customerName;
    private ArrayList<Double> custTrans = new ArrayList<Double>();

    public Customer(String customerName, double initTrans) {
        this.customerName = customerName;
        this.custTrans = new ArrayList<Double>();
        addTransaction(initTrans);
    }

    public void addTransaction(double amount) {
        this.custTrans.add(amount);
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getCustTrans() {
        return custTrans;
    }
}//close class
