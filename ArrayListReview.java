import java.util.ArrayList;

public class ArrayListReview {
    public static void main() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Kai");
        names.add("Ana");
        names.add(0, "Zoe");
        names.add("Ana");
        names.remove("Ana");

        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.contains("Ana"));
        System.out.println(names.indexOf("Kai"));
    }
}