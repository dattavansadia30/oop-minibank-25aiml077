
public class MiniBank {

    public static void main(String[] args) {

        System.out.println("=== Mobile Validation ===");
        System.out.println(Validator.isValidMobile("9876543210"));
        System.out.println(Validator.isValidMobile("12345"));

        System.out.println("\n=== Email Validation ===");
        System.out.println(Validator.isValidEmail("abc@xyz.com"));
        System.out.println(Validator.isValidEmail("abcxyz.com"));

        System.out.println("\n=== PAN Validation ===");
        System.out.println(Validator.isValidPan("ABCDE1234F"));
        System.out.println(Validator.isValidPan("12345"));

        System.out.println("\n=== IFSC Validation ===");
        System.out.println(Validator.isValidIfsc("SBIN0001234"));
        System.out.println(Validator.isValidIfsc("12345"));

        System.out.println("\n=== Command Parsing ===");
        Command command = CommandParser.parse("DEPOSIT AC0001 500");

        System.out.println("Type: " + command.type());
        System.out.println("Account Number: " + command.accountNumber());
        System.out.println("Amount: " + command.amount());

        System.out.println("\n=== Account Statement ===");
        Account account = new Account("Riya", 4000);
        System.out.println(StatementFormatter.buildStatement(account));
    }
}
