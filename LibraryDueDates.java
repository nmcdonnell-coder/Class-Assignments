import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
public class LibraryDueDates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate checkoutDate = LocalDate.now();
        LocalDate dueDate = checkoutDate.plusDays(21);
        if (dueDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            dueDate = dueDate.plusDays(2);
        } else if (dueDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            dueDate = dueDate.plusDays(1);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        long daysUntilDue = ChronoUnit.DAYS.between(LocalDate.now(), dueDate);
        System.out.println("Checkout date: " + checkoutDate.format(formatter));
        System.out.println("Due date: " + dueDate.format(formatter));
        System.out.println("Days until due: " + daysUntilDue);
        System.out.print("Enter return date (yyyy-mm-dd): ");
        LocalDate returnDate = LocalDate.parse(input.nextLine());
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        double fee = 0.0;
        if (daysLate > 0) {
            fee = daysLate * 0.25;
        }
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Late fee: " + currencyFormatter.format(fee));
        input.close();
    }
}

