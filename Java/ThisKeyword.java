class Example {
	
	String name;
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
}
public class ThisKeyword {
	
	public static void main(String[] args) {
		
		Example obj = new Example();
		obj.setName("Tanveer Hussain");
		System.out.println(obj.getName());
	}
	
}