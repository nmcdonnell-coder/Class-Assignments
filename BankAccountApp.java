import java.util.Scanner;
public class BankAccountApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = readName(scanner);
		if (name == null) {
			scanner.close();
			return;
		}
		double openingDeposit = readAmount(scanner, "Enter your opening deposit: $");
		if (Double.isNaN(openingDeposit)) {
			scanner.close();
			return;
		}
		BankAccount account = new SavingsAccount(name, openingDeposit);
		System.out.println("Welcome, " + account.getOwnerName() + "!");
		boolean running = true;
		while (running && scanner.hasNextLine()) {
			System.out.println("\n1. Deposit  2. Withdraw  3. Balance  4. Quit");
			System.out.print("Choose an option: ");
			String choice = scanner.nextLine().trim();
                if (choice.isEmpty()) {
                    continue;
                }
			switch (choice) {
				case "1": {
					double amount = readAmount(scanner, "Enter deposit amount: $");
					if (!Double.isNaN(amount)) {
						account.deposit(amount);
						System.out.printf("Balance: $%,.2f%n", account.getBalance());
					}
					break;
				}
				case "2": {
					double amount = readAmount(scanner, "Enter withdrawal amount: $");
					if (!Double.isNaN(amount)) {
						try {
							account.withdraw(amount);
							System.out.printf("Balance: $%,.2f%n", account.getBalance());
						} catch (InsufficientFundsException e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				}
				case "3":
					System.out.printf("Current balance: $%,.2f%n", account.getBalance());
					break;
				case "4":
					running = false;
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Enter 1, 2, 3, or 4.");
			}
		}
		scanner.close();
	}
	private static String readName(Scanner scanner) {
		while (scanner.hasNextLine()) {
			String name = scanner.nextLine().trim();
			if (!name.isEmpty()) {
				return name;
			}
			System.out.print("Name cannot be blank. Enter your name: ");
		}
		return null;
	}
private static double readAmount(Scanner scanner, String prompt) {
    while (true) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            return Double.NaN;
        }
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Input cannot be blank.");
            continue;
        }
        input = input.replace("$", "").replace(",", "");
        try {
            double amount = Double.parseDouble(input);
            if (Double.isFinite(amount) && amount >= 0) {
                return amount;
            }
        } catch (NumberFormatException ignored) {
        }
        System.out.println("Enter a valid non-negative amount.");
    }
}
}
class BankAccount {
	private final String ownerName;
	private double balance;
	public BankAccount(String ownerName, double openingDeposit) {
		this.ownerName = ownerName;
		this.balance = openingDeposit;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) throws InsufficientFundsException {
		if (amount > balance) {
			throw new InsufficientFundsException(
					String.format("Insufficient funds. Current balance: $%,.2f", balance));
		}
		balance -= amount;
	}
}
class SavingsAccount extends BankAccount {
	private static final double INTEREST_RATE = 0.01;
	public SavingsAccount(String ownerName, double openingDeposit) {
		super(ownerName, openingDeposit);
	}
	public void addInterest() {
		deposit(getBalance() * INTEREST_RATE);
	}
}
class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String message) {
		super(message);
	}
}