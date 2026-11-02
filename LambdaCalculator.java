import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class LambdaCalculator {
    interface MathOperation {
        double apply(double first, double second);
    }
    public static void main(String[] args) {
        Map<String, MathOperation> operations = new HashMap<>();
        operations.put("+", (first, second) -> first + second);
        operations.put("-", (first, second) -> first - second);
        operations.put("*", (first, second) -> first * second);
        operations.put("/", (first, second) -> first / second);
        operations.put("%", (first, second) -> first % second);
        System.out.println("Please provide an expression for me to calculate: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replace(" ", "");
        scanner.close();
        String operator = null;
        for (String possibleOperator : operations.keySet()) {
            if (input.contains(possibleOperator)) {
                operator = possibleOperator;
                break;
            }
        }
        if (operator == null) {
            System.out.println("Unknown operator");
            return;
        }
        String[] parts = input.split("\\" + operator);
        if (parts.length != 2) {
            System.out.println("Unknown operator");
            return;
        }
        MathOperation operation = operations.get(operator);
        try {
            double first = Double.parseDouble(parts[0]);
            double second = Double.parseDouble(parts[1]);
            double result = operation.apply(first, second);
            if (result == (long) result) {
                System.out.println((long) result);
            } else {
                System.out.println(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Unknown operator");
        }
    }
}
