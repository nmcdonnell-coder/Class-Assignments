import java.util.Scanner;
public class Name {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine().trim();
        String[] nameParts = fullName.isEmpty() ? new String[0] : fullName.split("\\s+");
        if (nameParts.length > 0) {
            System.out.println("First name: " + nameParts[0]);
            System.out.println("Last name: " + nameParts[nameParts.length - 1]);
            StringBuilder initials = new StringBuilder();
            for (String part : nameParts) {
                initials.append(Character.toUpperCase(part.charAt(0)));
            }
            System.out.println("Initials: " + initials);
        }
        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();
        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || !email.substring(atIndex + 1).contains(".")) {
            System.out.println("Invalid");
        } else {
            System.out.println("User: " + email.substring(0, atIndex));
            System.out.println("Domain: " + email.substring(atIndex + 1));
        }
        scanner.close();
    }
}