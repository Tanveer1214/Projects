public class displayData extends Student {
	
	public static void main(String[] args) {
		
		Student obj = new Student();
		obj.setName("Tanveer Hussain");
		obj.setRollno(35);
		obj.setAge(25);
		
		System.out.println("Name is "+obj.getName());
		System.out.println("RollNo is "+obj.getRollno());
		System.out.println("Age is "+obj.getAge());
		
	}
	
}