import java.util.Scanner;
public class LoginChecker {
	public static void main(String[] args) {
		String storedUsername = "admin";
		String storedPassword = "Secret123";
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Username: ");
			String username = scanner.nextLine();
			System.out.print("Password: ");
			String password = scanner.nextLine();

			if (storedUsername.equalsIgnoreCase(username)
					&& storedPassword.equals(password)) {
				System.out.println("Welcome");
			} else {
				System.out.println("Access Denied");
			}
			System.out.print("First name: ");
			String firstName = scanner.nextLine();
			System.out.print("Second name: ");
			String secondName = scanner.nextLine();
			if (firstName.compareTo(secondName) <= 0) {
				System.out.println(firstName + " comes first alphabetically.");
			} else {
				System.out.println(secondName + " comes first alphabetically.");
			}
		}
	}
}
