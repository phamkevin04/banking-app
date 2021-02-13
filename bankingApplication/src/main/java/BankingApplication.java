import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        BankAccount obj = new BankAccount("Timothy Kim", "1K3Z4S8PZ");
        obj.showMenu();
    }

    static class BankAccount {
        int balance; // variables
        int previousTransaction;
        String customerName;
        String customerID;

        BankAccount(String cName, String cId) { //constructor
            customerName = cName;
            customerID = cId;
        }

        void deposit(int amount) { // method to deposit
            if (amount != 0) {
                balance = balance + amount;
                previousTransaction = amount;
            }
        }

        void withdraw(int amount) { // method to withdraw
            if (amount != 0) {
                balance  = balance - amount; // to show that we TOOK out money
                previousTransaction = -amount;
            }
        }

        void getPreviousTransaction() {
            if(previousTransaction < 0) { // means previous transaction was a withdraw
                System.out.println("Last transaction [withdrawn]: " + Math.abs(previousTransaction));
            }
            else if(previousTransaction > 0) { // means previous transaction was a deposit
                System.out.println("Last transaction [deposited]: " + Math.abs(previousTransaction));
            }
            else {
                System.out.println("No transaction previously happened");
            }
        }

        void showMenu() {
            char option = '\0'; //initialize with 0 basically
            Scanner scanner = new Scanner(System.in);

            System.out.println("---------- Banking Application ----------");
            System.out.println("Hello " + customerName);
            System.out.println("Account ID: " + customerID + "\n");

            do
            {
                System.out.println("---------- Options ---------");

                //options
                System.out.println("A - Deposit Balance");
                System.out.println("B - Withdraw Balance");
                System.out.println("C - Previous Transaction");
                System.out.println("D - Current Balance");
                System.out.println("Z - Escape / Exit");

                System.out.print("\nEnter your option here:");
                option = scanner.next().charAt(0);

                System.out.println("\n");

                switch(option) {
                    case 'A': // Deposit Balance
                        System.out.print("Enter amount to deposit: ");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println("\n");
                        break;

                    case 'B': // Withdraw Amount
                        System.out.print("Enter amount to withdraw: ");
                        int amountWithdraw = scanner.nextInt();
                        withdraw(amountWithdraw);
                        System.out.println("\n");
                        break;

                    case 'C': // Previous Transaction
                        System.out.print("Previous transaction: ");
                        getPreviousTransaction();
                        System.out.println("\n");
                        break;

                    case 'D': // Current Balance
                        System.out.println("Current balance: " + balance);
                        System.out.println("\n");
                        break;

                    case 'Z':
                        System.out.println("Banking use ... done");
                        break;

                    default:
                        System.out.println("Option is not valid, please try again: ");
                        break;

                }
            }
            while(option != 'Z');
            System.out.println("Banking usage complete!");
        }
    }
}
