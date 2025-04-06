package assignment_banking_system;

//Task 1: Conditional Statements

//In a bank, you have been given the task is to create a program that checks if a customer is eligible for
//a loan based on their credit score and income. The eligibility criteria are as follows:
//• Credit Score must be above 700.
//• Annual Income must be at least $50,000.
//Tasks:
//1. Write a program that takes the customer's credit score and annual income as input.
//2. Use conditional statements (if-else) to determine if the customer is eligible for a loan.
//3. Display an appropriate message based on eligibility.




import java.util.Scanner;

public class LoanEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your credit score: ");
        int creditScore = scanner.nextInt();

        System.out.print("Enter your annual income: ");
        double annualIncome = scanner.nextDouble();

        if (creditScore > 700 && annualIncome >= 50000) {
            System.out.println("Congratulations! You are eligible for a loan.");
        } else {
            System.out.println("Sorry, you are not eligible for a loan.");
        }

        scanner.close();
    }
}

