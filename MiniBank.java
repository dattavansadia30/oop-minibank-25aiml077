
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

public class MiniBank {

    public static void main(String[] args) {

        Account account = new SavingsAccount(
                "AC0001", "Riya", 1000, 0);

        try {
            account.withdraw(5000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Shortfall: " + e.getShortfall());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction completed.");
        }

try (BankResource resource = new BankResource()) {
    resource.use();
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}

    }
}
