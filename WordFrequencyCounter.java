import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a paragraph:");
        String paragraph = scanner.nextLine().toLowerCase();
        String cleaned = paragraph.replaceAll("[^a-z\\s]", " ").trim();
        Map<String, Integer> counts = new TreeMap<>();
        if (!cleaned.isEmpty()) {
            for (String word : cleaned.split("\\s+")) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Word counts:");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Unique words: " + counts.size());
        String mostFrequent = null;
        int highestCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > highestCount) {
                mostFrequent = entry.getKey();
                highestCount = entry.getValue();
            }
        }
        System.out.println("Most frequent word: " +
                (mostFrequent == null ? "none" : mostFrequent + " (" + highestCount + ")"));
        scanner.close();
    }
}