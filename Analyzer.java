import java.util.Scanner;
public class Analyzer {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter a sentence: ");
            String sentence = scanner.nextLine().trim();
            String[] words = sentence.isEmpty() ? new String[0] : sentence.split("\\s+");
            int letters = 0;
            int digits = 0;
            int vowels = 0;
            String longestWord = "";
            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                if (Character.isLetter(ch)) {
                    letters++;
                    if ("aeiouAEIOU".indexOf(ch) >= 0) {
                        vowels++;
                    }
                } else if (Character.isDigit(ch)) {
                    digits++;
                }
            }
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            StringBuilder titleCase = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (i > 0) titleCase.append(' ');
                String word = words[i];
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase());
            }
            StringBuilder reversedWords = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                if (reversedWords.length() > 0) reversedWords.append(' ');
                reversedWords.append(words[i]);
            }
            String border = "=".repeat(40);
            System.out.println(border);
            System.out.println("Words: " + words.length);
            System.out.println("Letters: " + letters);
            System.out.println("Digits: " + digits);
            System.out.println("Vowels: " + vowels);
            System.out.println("Longest word: " + (longestWord.isEmpty() ? "(none)" : longestWord));
            System.out.println("Title Case: " + titleCase);
            System.out.println("Words in reverse order: " + reversedWords);
            System.out.println(border);
        }
    }
}
