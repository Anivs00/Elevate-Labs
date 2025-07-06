
import java.util.Scanner;

abstract class BankAccount {
    int accNo;
    String cName;
    String cCity;
    double balance;
    double depositAmt;
    Scanner sc = new Scanner(System.in);

    public BankAccount() {
        balance = 1000;
    }

    public void inputData() {
        System.out.print("Enter your name: ");
        cName = sc.nextLine();
        System.out.print("Enter your city: ");
        cCity = sc.nextLine();
        accNo++;
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
            System.out.println("Insufficient funds");
        } else {
            balance = balance - amt;
            System.out.println("Amount withdrawed successfully from savings account!");
            System.out.println("Current amount: " + balance);
        }
    }

    public void deposit() {
        System.out.print("Enter amount: ");
        depositAmt = sc.nextInt();
        balance = balance + depositAmt;
        System.out.println("Deposited successfully!");
        System.out.println("Current amount: " + balance);
    }

    double calculateInterest() {
        return 0;
    }
}

class CurrentAccount extends BankAccount {
    public void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance = balance - amt;
            System.out.println("Amount withdrawed successfully from current account!");
            System.out.println("Current amount: " + balance);
        }
    }

    public void deposit() {
        System.out.print("Enter amount: ");
        depositAmt = sc.nextInt();
        balance = balance + depositAmt;
        System.out.println("Deposited successfully!");
        System.out.println("Current amount: " + balance);
    }

    double calculateInterest() {
        return 0;
    }
}

class Interest1 extends SavingsAccount {
    public double calculateInterest() {
        return balance + (balance * (4.0 / 100));
    }
}

class Interest2 extends CurrentAccount {
    public double calculateInterest() {
        return balance + (balance * (2.0 / 100));
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        BankAccount B = new CurrentAccount();
        BankAccount S = new SavingsAccount();
        int accType = 0;
        int withdrawAmt = 0;
        double amt;
        Interest1 I1 = new Interest1();
        Interest2 I2 = new Interest2();
        while (true) {
            System.out.println();
            System.out.println("Enter 1 to create current account");
            System.out.println("Enter 2 to create savings account");
            System.out.println("Enter 3 to check balance");
            System.out.println("Enter 4 to deposit funds");
            System.out.println("Enter 5 to withdraw funds");
            System.out.println("Enter 6 to see amount after interest");
            System.out.println("Enter 7 to exit");
            System.out.println();
            System.out.print("Select option: ");
            option = sc.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    B.inputData();
                    accType = 1;
                    break;
                case 2:
                    S.inputData();
                    accType = 2;
                    break;
                case 3:
                    if (accType == 1) {
                        B.display();
                    } else if (accType == 2) {
                        S.display();
                    } else {
                        System.out.println("Create an account first");
                    }
                    break;
                case 4:
                    if (accType == 1) {
                        B.deposit();
                    } else if (accType == 2) {
                        S.deposit();
                    } else {
                        System.out.println("Create an account first");
                    }
                    break;
                case 5:
                    System.out.print("Enter amount to withdraw: ");
                    withdrawAmt = sc.nextInt();
                    if (accType == 1) {
                        B.withdraw(withdrawAmt);
                    } else if (accType == 2) {
                        S.withdraw(withdrawAmt);
                    } else {
                        System.out.println("Create an account first");
                    }
                    break;
                case 6:
                    if (accType == 1) {
                        amt = I1.calculateInterest();
                        System.out.println("Amount after interest: " + amt);
                    } else if (accType == 2) {
                        amt = I2.calculateInterest();
                        System.out.println("Amount after interest: " + amt);
                    } else {
                        System.out.println("Create an account first");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
