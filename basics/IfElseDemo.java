public class IfElseDemo {

    public static void main(String[] args) {

        int number = 10;
        int marks = 78;
        int age = 20;
        int income = 30000;

        // Simple if statement
        if (number > 0) {
            System.out.println("Number is positive");
        }

        //  if - else statement
        if (number % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }

        //  else if ladder
        if (marks >= 90) {
            System.out.println("Grade: A+");
        } else if (marks >= 80) {
            System.out.println("Grade: A");
        } else if (marks >= 70) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }

        // Nested if statement
        if (age >= 18) {
            if (income >= 25000) {
                System.out.println("Eligible for loan");
            } else {
                System.out.println("Not eligible for loan (low income)");
            }
        } else {
            System.out.println("Not eligible for loan (underage)");
        }
    }
}
