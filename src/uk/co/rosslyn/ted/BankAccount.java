package uk.co.rosslyn.ted;

public class BankAccount {

    private String accountNumber;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private double balance;

    //constructor 1
    public BankAccount() {
        System.out.println("Empty constructor called");
    }
    //constructor 2
    public BankAccount(String accountNumber, String customerName,
                       String customerEmail, String customerPhone, double balance){
        System.out.println("full constructor called");
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.balance = balance;
    }
    //constructor 3
    //use IntelliJ to build it! Code -> Generate -> Constructor


    public BankAccount(String accountNumber, String customerName, String customerEmail) {
        //I added default values
        this(accountNumber, customerName, customerEmail, "07879612162", 0.00);

        //intelliJ added this
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public void depositFunds(double deposit) {
        System.out.println("You deposited " + deposit);
        this.balance+= deposit;
    }
    public void withdrawFunds(double withdraw) {
        if(this.balance - withdraw >= 0) {
            System.out.println("You withdrew " + withdraw);
            this.balance -= withdraw;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public String getAccountNumber() {
        System.out.println("Account number is " + this.accountNumber);
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        System.out.println("Customer name is " + this.customerName);
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        System.out.println("Customer email is " + customerEmail);
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        System.out.println("Customer phone number is " + this.customerPhone);
        return this.customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public double getBalance() {
        System.out.println("Account balance is £" + this.balance);
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
} //close class





/* use this code for threads
class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

 class RyanAndMonicaJob implements Runnable {

    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Overdrawn");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up.");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
}*/