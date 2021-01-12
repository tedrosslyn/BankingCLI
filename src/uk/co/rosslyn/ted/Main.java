package uk.co.rosslyn.ted;

public class Main {

    public static void main(String[] args) {

        //create a bank instance
        Bank bank = new Bank("HSBC");
        //create a branch instance
        bank.addBranch("Dunfermline");
        bank.addBranch("Edinburgh");
        //add customers
        bank.addCustomer("Dunfermline", "Grant", 2134.56);
        bank.addCustomer("Edinburgh", "Stewart", 1212.99);
        bank.addCustomer("Dunfermline", "Rory", 3423.01);
        bank.addCustomer("Dunfermline", "Peter", 654.78);

        //add more transactions
        bank.addCustomerTransaction("Edinburgh", "Stewart", -123.67);
        bank.addCustomerTransaction("Edinburgh", "Stewart", -10.99);
        bank.addCustomerTransaction("Edinburgh", "Stewart", -5.56);
        bank.addCustomerTransaction("Dunfermline", "Grant", -15.56);
        bank.addCustomerTransaction("Dunfermline", "Grant", -29.99);
        bank.addCustomerTransaction("Dunfermline", "Grant", -55.54);
        bank.addCustomerTransaction("Dunfermline", "Grant", 17.68);
        bank.addCustomerTransaction("Dunfermline", "Rory", -27.68);
        bank.addCustomerTransaction("Dunfermline", "Rory", -222.00);
        bank.addCustomerTransaction("Dunfermline", "Rory", -3.45);
        bank.addCustomerTransaction("Dunfermline", "Peter", -234.00);
        bank.addCustomerTransaction("Dunfermline", "Peter", 345.67);

        bank.listCustomers("Dunfermline",false);
        System.out.println();
        bank.listCustomers("Dunfermline",true);
        System.out.println();
        bank.listCustomers("Edinburgh",false);
        System.out.println();
        bank.listCustomers("Edinburgh",true);

        //test adding when branch doesn't' exist
        if(!bank.addCustomer("Glasgow", "David", 34.99)){
            System.out.println("Glasgow branch doesn't exist!");
        }
        //test adding branch that already exists
        if(!bank.addBranch("Dunfermline")) {
            System.out.println("Branch already exists");
        }
        //add transaction to customer who doesn't exist
        if(!bank.addCustomerTransaction("Edinburgh", "Jimmy", 123.45 )) {
            System.out.println("Customer does not exist");
        }
        //test adding customer who already exists
        if(!bank.addCustomer("Dunfermline", "Grant", 34.99)){
            System.out.println("Customer already exists!");
        }

    }
}
