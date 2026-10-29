
public class MiniBank {

    public static void main(String[] args) {

        Account a1 = new Account("AC0001", "Riya", 4000);
        Account a2 = new Account("AC0001", "Riya", 4000);
        Account a3 = new Account("Aarav", 3000);

        System.out.println("MiniBank - Practical 3");
        System.out.println("----------------------");

        System.out.println("Account 1: " + a1);
        System.out.println("Account 2: " + a2);
        System.out.println("Account 3: " + a3);

        System.out.println("\nAre a1 and a2 equal? " + a1.equals(a2));

        Object obj = a1;
        System.out.println("Is obj an Account? " + (obj instanceof Account));

        Customer c1 = new Customer(
            "Riya", "riya@gmail.com", "9876543210"
        );

        Customer.Address address = new Customer.Address(
            "Main Road", "Vadodara", "391101"
        );

        c1.setAddress(address);

        System.out.println("\nCustomer: " + c1.getName());
        System.out.println("Customer ID: " + c1.getCustomerId());
        System.out.println("City: " + c1.getAddress().getCity());

        Customer c2 = c1.clone();
        System.out.println("Cloned customer: " + c2.getName());
        System.out.println("Clone created: " + (c1 != c2));
    }
}
