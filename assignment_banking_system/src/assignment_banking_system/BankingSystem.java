package assignment_banking_system;
import java.util.*;

public class BankingSystem {
    static Map<String, Double> accounts = new HashMap<>();
    static List<String> transactions = new ArrayList<>();

    public static void main(String[] args) {
        accounts.put("1001", 5000.0);
        accounts.put("1002", 7500.0);
        accounts.put("1003", 3000.0);
        
        try (Scanner scanner = new Scanner(System.in)) {
			// Task 4: Checking Account Balance
			while (true) {
			    System.out.print("Enter your account number: ");
			    String accountNumber = scanner.next();
			    if (accounts.containsKey(accountNumber)) {
			        System.out.println("Your account balance is: $" + accounts.get(accountNumber));
			        break;
			    } else {
			        System.out.println("Invalid account number. Please try again.");
			    }
			}

			// Task 5: Password Validation
			while (true) {
			    System.out.print("Create a password for your bank account: ");
			    String password = scanner.next();
			    String validationMessage = validatePassword(password);
			    System.out.println(validationMessage);
			    if (validationMessage.equals("Password is valid.")) {
			        break;
			    }
			}

			// Task 6: Transaction History Management
			while (true) {
			    System.out.println("\nEnter 'D' to deposit, 'W' to withdraw, or 'E' to exit: ");
			    String action = scanner.next().toUpperCase();
			    if (action.equals("E")) {
			        break;
			    } else if (action.equals("D") || action.equals("W")) {
			        System.out.print("Enter the amount: ");
			        double amount = scanner.nextDouble();
			        transactions.add((action.equals("D") ? "Deposit: " : "Withdrawal: ") + "$" + amount);
			    } else {
			        System.out.println("Invalid choice. Try again.");
			    }
			}
		}
        
        System.out.println("\nTransaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static String validatePassword(String password) {
        if (password.length() < 8) {
            return "Password must be at least 8 characters long.";
        }
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter.";
        }
        if (!password.matches(".*\\d.*")) {
            return "Password must contain at least one digit.";
        }
        return "Password is valid.";
    }
}
