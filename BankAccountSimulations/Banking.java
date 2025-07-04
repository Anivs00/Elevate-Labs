import java.util.Scanner;

abstract class BankAccount {
    static int accNoCounter = 1000;
    int accNo;
    String cName;
    String cCity;
    double balance;
    double depositAmt;
    Scanner sc = new Scanner(System.in);

    public BankAccount() {
        accNo = ++accNoCounter;
        balance = 1000;
    }

    public void inputData() {
        System.out.print("Enter your name: ");
        cName = sc.nextLine();
        System.out.print("Enter your city: ");
        cCity = sc.nextLine();
    }

    public void display() {
        System.out.println("Account number: " + accNo);
        System.out.println("Name: " + cName);
        System.out.println("City: " + cCity);
        System.out.println("Funds: " + balance);
    }

    abstract public void deposit();

    abstract void withdraw(double amt);

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {
    public void withdraw(double amt) {
        if (balance - amt < 1000) {
            System.out.println("Insufficient funds. Minimum balance of 1000 must be maintained.");
        } else {
            balance -= amt;
            System.out.println("Amount withdrawn successfully from savings account!");
            System.out.println("Current amount: " + balance);
        }
    }

    public void deposit() {
        System.out.print("Enter amount: ");
        depositAmt = sc.nextDouble();
        balance += depositAmt;
        System.out.println("Deposited successfully!");
        System.out.println("Current amount: " + balance);
    }

    double calculateInterest() {
        return balance + (balance * 0.04); // 4% interest
    }
}

class CurrentAccount extends BankAccount {
    public void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amt;
            System.out.println("Amount withdrawn successfully from current account!");
            System.out.println("Current amount: " + balance);
        }
    }

    public void deposit() {
        System.out.print("Enter amount: ");
        depositAmt = sc.nextDouble();
        balance += depositAmt;
        System.out.println("Deposited successfully!");
        System.out.println("Current amount: " + balance);
    }

    double calculateInterest() {
        return balance + (balance * 0.02); // 2% interest
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        int option;

        while (true) {
            System.out.println();
            System.out.println("--- Bank Menu ---");
            System.out.println("1. Create Current Account");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit Funds");
            System.out.println("5. Withdraw Funds");
            System.out.println("6. See Amount After Interest");
            System.out.println("7. Exit");
            System.out.println();
            System.out.print("Select option: ");
            option = sc.nextInt();
            sc.nextLine(); // To consume leftover newline
            System.out.println();

            switch (option) {
                case 1:
                    account = new CurrentAccount();
                    account.inputData();
                    System.out.println("Current account created successfully.");
                    break;

                case 2:
                    account = new SavingsAccount();
                    account.inputData();
                    System.out.println("Savings account created successfully.");
                    break;

                case 3:
                    if (account != null) {
                        account.display();
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 4:
                    if (account != null) {
                        account.deposit();
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 5:
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmt = sc.nextDouble();
                        account.withdraw(withdrawAmt);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 6:
                    if (account != null) {
                        double amountWithInterest = account.calculateInterest();
                        System.out.println("Amount after interest: " + amountWithInterest);
                    } else {
                        System.out.println("Please create an account first.");
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the banking system.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    