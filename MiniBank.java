
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MiniBank {

    public static void main(String[] args) {

        try {
            Path dataFolder = Path.of("data");
            Path logsFolder = dataFolder.resolve("logs");

            Files.createDirectories(logsFolder);

            Account[] accounts = {
                new SavingsAccount("AC0001", "Riya", 1000, 0)
            };

            // Save accounts
            Path accountFile = dataFolder.resolve("accounts.dat");
            StatePersister.save(accounts, accountFile);
            System.out.println("Accounts saved.");

            // Load accounts
            Account[] loadedAccounts = StatePersister.load(accountFile);

            System.out.println("\nLoaded Accounts:");
            for (Account account : loadedAccounts) {
                System.out.println(account);
            }

            // Add transaction logs
            Path logFile = logsFolder.resolve("transactions.log");

            TransactionLog.append(logFile, "DEPOSIT AC0001 500");
            TransactionLog.append(logFile, "WITHDRAW AC0001 200");

            // Generate report
            Path reportFile = dataFolder.resolve("report.txt");

            ReportGenerator.generate(logsFolder, reportFile);

            System.out.println("Report saved successfully.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
