package assignment_banking_system;
import java.util.Scanner;

public class BankBalanceCheck {
    public static void main(String[] args) {
        // Arrays to store account numbers and their respective balances
        String[] accountNumbers = {"1001", "1002", "1003", "1004"};
        double[] balances = {5000.50, 3000.00, 7500.75, 10000.25};

        Scanner scanner = new Scanner(System.in);
        String accountNumber;
        boolean found = false;

        while (true) {
            System.out.print("Enter your account number: ");
            accountNumber = scanner.nextLine();

            // Check if the entered account number exists in the array
            for (int i = 0; i < accountNumbers.length; i++) {
                if (accountNumbers[i].equals(accountNumber)) {
                    System.out.println("Account Number: " + accountNumber + ", Balance: Rs." + balances[i]);
                    found = true;
                    break;
                }
            }

            if (found) {
                break; // Exit loop after successful balance check
            } else {
                System.out.println("Invalid account number. Please try again.");
            }
        }
        scanner.close();
    }
}
