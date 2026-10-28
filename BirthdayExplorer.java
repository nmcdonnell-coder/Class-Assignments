import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;
public class BirthdayExplorer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your birthday (yyyy-mm-dd): ");
        LocalDate birthday = LocalDate.parse(input.nextLine());
        System.out.println("Day of the week born: " + birthday.getDayOfWeek());
        System.out.println("Day of the year: " + birthday.getDayOfYear());
        if (Year.isLeap(birthday.getYear())) {
            System.out.println("Was that year a leap year?: yes");
        } else {
            System.out.println("Was that year a leap year?: no");
        }
        LocalDate currentBirthday = birthday.withYear(LocalDate.now().getYear());
        if (currentBirthday.isBefore(LocalDate.now())) {
            System.out.println("Did this year's birthday already pass?: yes");
        } else {
            System.out.println("Did this year's birthday already pass?: no");
        }
        input.close();
    }
}

