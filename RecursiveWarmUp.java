public class RecursiveWarmUp {
    public static int sumDigits(int number) {
        if (number < 10) {
            return number;
        }
        return number % 10 + sumDigits(number / 10);
    }
    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    public static int countChar(String str, char target) {
        if (str.isEmpty()) {
            return 0;
        }
        int count = str.charAt(0) == target ? 1 : 0;
        return count + countChar(str.substring(1), target);
    }
    public static void printBinary(int number) {
        if (number == 0) {
            return;
        }
        printBinary(number / 2);
        System.out.print(number % 2);
    }
    public static void main(String[] args) {
        System.out.println("1. Sum Digits: " + sumDigits(4096));
        System.out.println("2. Power: " + power(2, 10));
        System.out.println("3. Count Character: " + countChar("banana", 'a'));
        System.out.print("4. Binary: ");
        printBinary(10);
        System.out.println();
    }
}
