/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author tiwar
 */
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    class BankAccount {
    final String accountNumber;
    final String accountHolderName;
    private String password;
    private double balance;

    final List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolderName ,String password) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.transactionHistory.add("Deposit: " + amount);
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            this.transactionHistory.add("Withdrawal: " + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void transfer(BankAccount otherAccount, double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            otherAccount.deposit(amount);
            this.transactionHistory.add("Transfer: " + amount + " to " + otherAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void printTransactionHistory() {
        for (String transaction : this.transactionHistory) {
            System.out.println(transaction);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        
        System.out.print("enter the password: ");
        String password=scanner.nextLine();
        
        BankAccount account = new BankAccount(accountNumber, accountHolderName ,password);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View transaction history");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                account.deposit(amount);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                account.withdraw(amount);
            } else if (choice == 3) {
                System.out.print("Enter account number to transfer to: ");
                String otherAccountNumber = scanner.next();
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                BankAccount otherAccount = new BankAccount(otherAccountNumber, "","");
                account.transfer(otherAccount, amount);
            } else if (choice == 4) {
                account.printTransactionHistory();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
           
