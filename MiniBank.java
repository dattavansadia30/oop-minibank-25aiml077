
public class MiniBank {

    public static void main(String[] args) {

        Repository<Account> repository = new Repository<>();

        Account a1 = new SavingsAccount("AC0001", "Riya", 5000, 0);
        Account a2 = new SavingsAccount("AC0002", "Aarav", 2000, 0);
        Account a3 = new SavingsAccount("AC0003", "Diya", 9000, 0);

        // Save accounts
        repository.saveAll(a1, a2, a3);

        // Find account by ID
        System.out.println("Account Found:");
        System.out.println(repository.findById("AC0002"));

        // Print all accounts
        System.out.println("\nAll Accounts:");
        for (Account account : repository.findAll()) {
            System.out.println(account);
        }

        // Test average method
        Integer[] numbers = {10, 20, 30};
        System.out.println("\nAverage: "
                + Repository.average(numbers));
    }
}
