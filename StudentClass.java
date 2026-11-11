public class StudentClass {
	private String name;
	private int id;
	private double gpa;
	public StudentClass(String name, int id, double gpa) {
		this.name = name;
		this.id = id;
		setGpa(gpa);
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		if (gpa < 0.0 || gpa > 4.0) {
			throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
		}
		this.gpa = gpa;
	}
	public String getStudent() {
		return name + ", " + id + ", " + gpa;
	}
	public static void main(String[] args) {
		StudentClass student1 = new StudentClass("Nicole", 1118, 3.75);
		StudentClass student2 = new StudentClass("Mateo", 831, 3.5);
		StudentClass student3 = new StudentClass("Ray", 604, 2.5);
		System.out.println(student1.getStudent());
		System.out.println(student2.getStudent());
		System.out.println(student3.getStudent());
	}
}
