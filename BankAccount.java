import java.util.ArrayList;

public class BankAccount {

    private double balance;
    private ArrayList<String> history;

    public BankAccount(double balance) {
        this.balance = balance;
        history = new ArrayList<>();
        history.add("Account Created with INR " + balance);
    }

    public void deposit(double amount) {

        if(amount<=0){
            System.out.println("Invalid Amount.");
            return;
        }

        balance += amount;

        history.add("Deposited INR " + amount);

        System.out.println("INR " + amount + " Deposited Successfully.");

    }

    public void withdraw(double amount){

        if(amount<=0){
            System.out.println("Invalid Amount.");
            return;
        }

        if(amount>balance){
            System.out.println("Insufficient Balance.");
            return;
        }

        balance -= amount;

        history.add("Withdraw INR" + amount);

        System.out.println("INR " + amount + " Withdrawn Successfully.");

    }

    public double getBalance(){
        return balance;
    }

    public void showHistory(){

        System.out.println("\n====== Transaction History ======");

        for(String h : history){
            System.out.println(h);
        }

    }

}