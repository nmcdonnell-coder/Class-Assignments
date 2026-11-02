import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class SalesReport {
    record Sale(String product, String region, int qty, double price) {
    }
    public static void main(String[] args) {
        List<Sale> sales = List.of(
            new Sale("Candle", "Upper Treasure Valley", 2, 25.00),
            new Sale("Mouse", "Lower Treasure Valley", 2, 75.00),
            new Sale("Keyboard", "East Idaho", 1, 95.00),
            new Sale("Monitor", "North Idaho", 1, 60.00),
            new Sale("Computer", "Idaho-Oregon border", 1, 800.00),
            new Sale("Fan", "South Idaho", 1, 125.00),
            new Sale("Pencil container", "Idaho-Montana border", 4, 20.00),
            new Sale("Tape", "Idaho-Washington border", 3, 12.00),
            new Sale("Notebook", "Idah-Utah border", 9, 5.00),
            new Sale("Printer", "Idaho-Nevada border", 1, 85.00)
        );
        double totalRevenue = sales.stream()
            .mapToDouble(sale -> sale.qty() * sale.price())
            .sum();
        System.out.printf("Total revenue: $%.2f%n", totalRevenue);
        System.out.println("Products with revenue over $100:");
        sales.stream()
            .filter(sale -> sale.qty() * sale.price() > 100)
            .map(Sale::product)
            .distinct()
            .sorted()
            .forEach(System.out::println);
        Sale biggestSale = sales.stream()
            .max((first, second) -> Double.compare(
                first.qty() * first.price(), second.qty() * second.price()))
            .orElseThrow();
        System.out.printf("Biggest sale: %s in %s, revenue $%.2f%n",
            biggestSale.product(), biggestSale.region(),
            biggestSale.qty() * biggestSale.price());
        Map<String, Double> revenueByRegion = sales.stream()
            .collect(Collectors.groupingBy(
                Sale::region,
                Collectors.summingDouble(sale -> sale.qty() * sale.price())));
        System.out.println("Revenue per region:");
        revenueByRegion.forEach((region, revenue) ->
            System.out.printf("%s: $%.2f%n", region, revenue));
    }
}
