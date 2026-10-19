public class JavaString {
public static void main(String[] args) {
String a = "java";
String b = "java";
String c = new String("java");

System.out.println(a == b);
System.out.println(a == c);
System.out.println(a.equals(c));

a.toUpperCase();
System.out.println(a);

String greeting = "Hello, Java";
System.out.println(greeting);
System.out.println(greeting.length());
System.out.printf("%s \n", greeting.charAt(0));

char septimus = greeting.charAt(6);
System.out.printf("%s \n", septimus);

char eleventh = greeting.charAt(greeting.length() - 1);
}
}