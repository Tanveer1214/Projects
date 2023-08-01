class Example {
	
	enum level {
		Low,
		Medium,
		High	
	}
	
	level SelectedLevel;
}

public class Java_Enums {
	
	public static void main(String []args) {
		Example obj = new Example();
		obj.SelectedLevel = Example.level.Medium;
		System.out.println("Your Selected level is "+obj.SelectedLevel);
	}
	
}
/*
Enums were introduced in Java 5.0. Enums restrict a variable to have one of only a few predefined values. 
The values in this enumerated list are called enums. 
With the use of enums it is possible to reduce the number of bugs in your code. 
*/