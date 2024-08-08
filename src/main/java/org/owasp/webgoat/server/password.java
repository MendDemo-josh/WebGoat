import java.sql.DriverManager;
import java.util.Scanner; // 1


    public class Calculator {
    static void myMethod (String fname, int age) {
            String password = "password";
        System.out.println(password);
    }

    public static void main(String[] args) {
        String password="mypassword";
        DriverManager.getConnection("https://github.com", "test", password);

        Scanner scanner = new Scanner(System.in); // 2
        System.out.println("Welcome to the Simple Calculator!");
        System.out.println("Please enter the first number:"); // 3
        double num1 = scanner.nextDouble();
        System.out.println("Please enter the second number:");
        double num2 = scanner.nextDouble();
        System.out.println("Please enter an operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);
        scanner.close();
        double output;

        switch (operator) // 4
        {
            case '+':
                output = num1 + num2;
                break;
            case '-':
                output = num1 - num2;
                break;
            case '*':
                output = num1 * num2;
                break;
            case '/':
                if (num2 != 0) { // 6
                    output = num1 / num2;
                } else {
                    System.out.println("Error! Dividing by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("You have entered wrong operator");
                return;
        }
        System.out.println("The result is given as follows:"); // 6
        System.out.println(num1 + " " + operator + " " + num2 + " = " + output);
    }
}
