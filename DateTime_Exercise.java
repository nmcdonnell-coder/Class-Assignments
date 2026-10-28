import java.time.*;

public class DateTime_Exercise {
    public static void main() {
        LocalDate d = LocalDate.of(2026, 1, 31);
        LocalDate c = d.plusMonths(1);
        System.out.printf("%s\n", d.plusMonths(1).toString());
        System.out.printf("%s\n", c);
        c = c.plusDays(30);
        System.out.println(d.plusDays(30).toString().toCharArray());
        System.out.printf("%s\n", c);
        System.out.println(d.getDayOfWeek());
        System.out.println(d);
    }
}
