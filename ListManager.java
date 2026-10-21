import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ListManager {
	public static void main(String[] args) {
		List<String> tasks = new ArrayList<>(List.of(
				"finish class",
				"go to library",
				"check out new book",
				"study",
				"play games with friends",
                "get tasty midnight snack",
                "go to bed"
		));
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Menu: add, remove <number>, list, done <number>, quit");
				String input = scanner.nextLine().trim();
				if (input.isEmpty()) {
					continue;
				}
				String[] parts = input.split("\\s+", 2);
				String command = parts[0].toLowerCase();
				String argument = parts.length > 1 ? parts[1].trim() : "";
				switch (command) {
					case "add":
						if (argument.isEmpty()) {
							System.out.println("Task to add:");
							argument = scanner.nextLine().trim();
						}
						if (!argument.isEmpty()) {
							tasks.add(argument);
						}
						break;
					case "remove":
					case "done":
						try {
							int number = Integer.parseInt(argument);
							if (number < 1 || number > tasks.size()) {
								System.out.println("oops, that option is unavailable");
							} else {
								tasks.remove(number - 1);
							}
						} catch (NumberFormatException e) {
							System.out.println("oops, that option is unavailable");
						}
						break;
					case "list":
						for (int i = 0; i < tasks.size(); i++) {
							System.out.println((i + 1) + ". " + tasks.get(i));
						}
						break;
					case "quit":
						return;
					default:
						System.out.println("oops, that option is unavailable");
				}
			}
		}
	}
}
