import java.util.Scanner;

public class SimpleCalculator {

    private static double answer = 0.0;
    private static String lastOperator = "+"; 
    private static boolean afterNewOperator = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First enter a number. Type 'exit' to quit");
        System.out.println("----------------------------------------");

        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                break;
            }

            if (convertableToNumber(input)) {
                double number = Double.parseDouble(input);
                
                if (afterNewOperator) {
                    answer = number;
                    afterNewOperator = false;
                } else {
                    switch (lastOperator) {
                        case "+": answer += number; break;
                        case "-": answer -= number; break;
                        case "*": answer *= number; break;
                        case "/": answer /= number; break;
                        case "=": answer = number; break;
                    }
                }
                
                System.out.println("Screen: " + answer);

            } else {
                switch (input) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        lastOperator = input;
                        System.out.println("Display: " + answer); 
                        break;
                    case "=":
                        lastOperator = "+"; // go back to default 
                        afterNewOperator = true;
                        System.out.println("Display: " + answer);
                        break;
                }

            }
        }
        scanner.close();
    }

    private static boolean convertableToNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}