//Task 2: Nested Conditional Statements
//Create a program that simulates an ATM transaction. Display options such as "Check Balance,"
//"Withdraw," "Deposit,". Ask the user to enter their current balance and the amount they want to
//withdraw or deposit. Implement checks to ensure that the withdrawal amount is not greater than the
//available balance and that the withdrawal amount is in multiples of 100 or 500. Display appropriate
//messages for success or failure.

package assignment_banking_system;
import java.util.Scanner;
public class ATMTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter your current balance: ");
        double balance = sc.nextDouble();
        
        while (true){
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = sc.nextInt();
            
            if (choice == 1) {
                System.out.println("Your current balance is: $" + balance);
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = sc.nextDouble();
                
                if (withdrawAmount > balance) {
                    System.out.println("Insufficient balance!");
                } else if (withdrawAmount % 100 != 0 && withdrawAmount % 500 != 0) {
                    System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
                } else {
                    balance -= withdrawAmount;
                    System.out.println("Withdrawal successful! Remaining balance: $" + balance);
                }
            } else if (choice == 3) {
                System.out.print("Enter deposit amount: ");
                double depositAmount = sc.nextDouble();
                
                if (depositAmount <= 0) {
                    System.out.println("Invalid deposit amount.");
                } else {
                    balance += depositAmount;
                    System.out.println("Deposit successful! New balance: $" + balance);
                }
            } else if (choice == 4) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
        
        sc.close();
    }
}

 
