package Admin;
import department.Student; // importing another package class
public class Administration {
	
	public static void main(String[] args) {
		
		Student s = new Student();
		s.setData("Tanveer Hussain",035);
		s.displayData();
		
	}
	
}

/**
Compile:
javac -d . Administration.java

Run:
java Admin.Administration
*.