package department;
public class Student {
	
	private String name;
	private int rollno;
	
	public void setData(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}
	
	public void displayData() {
		System.out.println("Student name is "+name);
		System.out.println("Student RollNo is "+rollno);
	}
	
}