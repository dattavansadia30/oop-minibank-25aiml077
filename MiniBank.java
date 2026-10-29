
public class MiniBank {

    public static void main(String[] args) throws InterruptedException {

        AccountStore store = new AccountStore();

        Account a1 = new SavingsAccount("AC0001", "Riya", 5000, 0);
        Account a2 = new SavingsAccount("AC0002", "Aarav", 2000, 0);
        Account a3 = new SavingsAccount("AC0003", "Diya", 9000, 0);

        // Add accounts to the store
        store.add(a1);
        store.add(a2);
        store.add(a3);

        // Search by account number
        System.out.println("Account Found:");
        System.out.println(store.get("AC0002"));

        // Add transaction history
        store.addTransaction("DEPOSIT AC0001 500");
        store.addTransaction("WITHDRAW AC0002 200");

        System.out.println("\nTransaction History:");
        for (String transaction : store.getTransactionHistory()) {
            System.out.println(transaction);
        }

        // Sort accounts by balance
        System.out.println("\nAccounts Sorted by Balance:");
        for (Account account : store.sortedByBalance()) {
            System.out.println(account);
        }

        // Use thread-safe account storage
        TransactionProcessor processor = new TransactionProcessor();

        processor.addAccount(a1);
        processor.addAccount(a2);
        processor.addAccount(a3);

        System.out.println("\nThread-safe Account Lookup:");
        System.out.println(processor.getAccount("AC0002"));

        processor.stop();
    }
}
