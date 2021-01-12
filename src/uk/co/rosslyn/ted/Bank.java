package uk.co.rosslyn.ted;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<>();

    public Bank(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    public static void addBranch(){

    }

    public static void addCustomer() {

    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }
}
