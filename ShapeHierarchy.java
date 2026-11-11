import java.util.Arrays;
import java.util.List;
abstract class Shape {
	abstract double area();
	String getShape() {
		return getClass().getSimpleName() + ", " + area();
	}
}
class Circle extends Shape {
	private final double radius;
	Circle(double radius) {
		this.radius = radius;
	}
	@Override
	double area() {
		return Math.PI * radius * radius;
	}
}
class Rectangle extends Shape {
	private final double width;
	private final double height;
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	@Override
	double area() {
		return width * height;
	}
}
class Square extends Rectangle {
	Square(double side) {
		super(side, side);
	}
}
public class ShapeHierarchy {
	public static void main(String[] args) {
		List<Shape> shapes = Arrays.asList(
				new Circle(11),
				new Rectangle(11, 18),
				new Square(18)
		);
		for (Shape shape : shapes) {
			System.out.println(shape.getShape());
		}
	}
}
