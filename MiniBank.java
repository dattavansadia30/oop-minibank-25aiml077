
public class MiniBank {

    public static void main(String[] args) {

        Account[] accounts = {
            new SavingsAccount("AC0001", "Riya", 10000, 2000),
            new CurrentAccount("AC0002", "Rahul", 5000, 3000),
            new FixedDepositAccount("AC0003", "Priya", 20000)
        };

        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("Owner: " + account.getOwnerName());
            System.out.println("Interest Rate: " + account.interestRate());
            System.out.println("Monthly Interest: " + account.monthlyInterest());

            if (account instanceof SavingsAccount savings) {
                System.out.println("Savings Account detected.");
                System.out.println("Can withdraw 1000: "
                        + savings.canWithdraw(1000));
            }

            System.out.println("-------------------------");
        }
    }
}
