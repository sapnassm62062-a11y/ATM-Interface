import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private Scanner sc;

    private final int PIN = 1234;

    public ATM(BankAccount account){

        this.account = account;
        sc = new Scanner(System.in);

    }

    public void start(){

        int attempts = 3;

        while(attempts>0){

            System.out.print("Enter ATM PIN : ");

            int pin = sc.nextInt();

            if(pin==PIN){
                System.out.println("\nLogin Successful.");
                menu();
                return;
            }

            attempts--;

            System.out.println("Wrong PIN.");

            if(attempts>0)
                System.out.println("Attempts Left : "+attempts);

        }

        System.out.println("ATM Blocked.");

    }

    private void menu(){

        while(true){

            System.out.println("\n==============================");
            System.out.println("        JAVA ATM");
            System.out.println("==============================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Fast Cash");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose : ");

            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    System.out.print("Enter Amount : ");

                    account.deposit(sc.nextDouble());

                    break;

                case 2:

                    System.out.print("Enter Amount : ");

                    account.withdraw(sc.nextDouble());

                    break;

                case 3:

                    System.out.println("Current Balance : INR " + account.getBalance());

                    break;

                case 4:

                    fastCash();

                    break;

                case 5:

                    account.showHistory();

                    break;

                case 6:

                    System.out.println("Thank You.");

                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void fastCash(){

        System.out.println("\nFast Cash");

        System.out.println("1. ₹500");
        System.out.println("2. ₹1000");
        System.out.println("3. ₹2000");
        System.out.println("4. ₹5000");

        System.out.print("Select : ");

        int ch=sc.nextInt();

        switch(ch){

            case 1:
                account.withdraw(500);
                break;

            case 2:
                account.withdraw(1000);
                break;

            case 3:
                account.withdraw(2000);
                break;

            case 4:
                account.withdraw(5000);
                break;

            default:
                System.out.println("Invalid Option.");

        }

    }

}