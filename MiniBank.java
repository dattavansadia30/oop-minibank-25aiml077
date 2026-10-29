
import java.util.Scanner;

record BankInfo(String name, String branch) {}

enum MenuOption {
    OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER, EXIT
}

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Changa Campus");

        System.out.println("========================");
        System.out.println(bank.name());
        System.out.println(bank.branch());
        System.out.println("========================");

        Customer c1 = new Customer("Riya", "riya@gmail.com", "9876543210");
        Customer c2 = new Customer("Aarav", "aarav@gmail.com", "9876543211");
        Customer c3 = new Customer("Diya", "diya@gmail.com", "9876543212");

        System.out.println("\nCustomer IDs:");
        System.out.println(c1.getName() + " - " + c1.getCustomerId());
        System.out.println(c2.getName() + " - " + c2.getCustomerId());
        System.out.println(c3.getName() + " - " + c3.getCustomerId());

        Account[] accounts = {
            new Account("Riya", 5000),
            new Account("Aarav"),
            new Account("Diya", 3000)
        };

        accounts[0].deposit(2000);
        System.out.println("\nBalance after deposit: " + accounts[0].getBalance());

        boolean success = accounts[0].withdraw(3000);
        System.out.println("Withdrawal successful: " + success);
        System.out.println("Balance: " + accounts[0].getBalance());

        success = accounts[0].withdraw(10000);
        System.out.println("Withdrawal successful: " + success);
        System.out.println("Balance: " + accounts[0].getBalance());

        System.out.println("\nAll Account Details:");
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " | "
                    + account.getOwnerName() + " | Balance: "
                    + account.getBalance());
        }

        boolean running = true;

        while (running) {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            MenuOption option = switch (choice) {
                case 1 -> MenuOption.OPEN_ACCOUNT;
                case 2 -> MenuOption.DEPOSIT;
                case 3 -> MenuOption.WITHDRAW;
                case 4 -> MenuOption.TRANSFER;
                case 5 -> MenuOption.EXIT;
                default -> null;
            };

            if (option == null) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            switch (option) {
                case OPEN_ACCOUNT ->
                    System.out.println("Open Account - to be implemented in a later lab");
                case DEPOSIT ->
                    System.out.println("Deposit - to be implemented in a later lab");
                case WITHDRAW ->
                    System.out.println("Withdraw - to be implemented in a later lab");
                case TRANSFER ->
                    System.out.println("Transfer - to be implemented in a later lab");
                case EXIT -> {
                    System.out.println("Thank you for using MiniBank!");
                    running = false;
                }
            }
        }

        sc.close();
    }
}
