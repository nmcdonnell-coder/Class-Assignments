import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class StudentRoster {
    record Student(String name, String major, double gpa) {}
    public static void main(String[] args) {
        List<Student> roster = new ArrayList<>(List.of(
                new Student("Nicole McDonnell", "Software Development", 3.7),
                new Student("Mateo Marrara", "Automotive", 3.5),
                new Student("Tom Hanks", "Filmography", 3.4),
                new Student("Jack Daniels", "Chemistry", 3.2),
                new Student("Raymond Mahner", "Astronomy", 2.5),
                new Student("Lulu Lemon", "Cosmotology", 3.1),
                new Student("Ayden Chernicky", "Photography", 2.0),
                new Student("Huxy Wuxy", "Physics", 3.8)
        ));
        System.out.println("Sorted by name:");
        roster.stream()
                .sorted(Comparator.comparing(Student::name))
                .forEach(System.out::println);
        System.out.println("\nSorted by major, then GPA high to low:");
        roster.stream()
                .sorted(Comparator.comparing(Student::major)
                        .thenComparing(Student::gpa, Comparator.reverseOrder()))
                .forEach(System.out::println);
        roster.removeIf(student -> student.gpa() < 2.0);
        System.out.println("\nRemaining names in uppercase:");
        roster.forEach(student -> System.out.println(student.name().toUpperCase()));
    }
}
