public class String_Class {
	
	public static void main(String[] args) {
	
		String s = "Tanveer";
        String s2 = "Tanveer"; // here s2 and s will point same object because the value of both is same.
		
		String s3 = new String("Tanveer"); // here new object will create for s3 because we use new keyword.
		
        System.out.println(s.equals("Tani"));
        System.out.println(s.isEmpty());
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.charAt(0));
        System.out.println(s.compareTo(s2));
        System.out.println(s.compareToIgnoreCase(s2));
        System.out.println(s.concat(" Hussain"));
        System.out.println(s.indexOf("v"));
        System.out.println(s.matches("Tanveer"));
        System.out.println(s.getBytes(StandardCharsets.UTF_8));
        System.out.println(s.chars());
        System.out.println(s.codePointAt(4));
        System.out.println(s.isBlank());
        System.out.println(s.lines());
        System.out.println(s.repeat(2));
        System.out.println(s.replace('v','e'));
        System.out.println(s.substring(2));
        System.out.println(s.substring(3,6));
        System.out.println(s.endsWith("r"));
        System.out.println(s.trim());
        System.out.println(s.subSequence(1,5));
	
	}
	
}
/*
 In Java programming language, strings are treated as objects.
 The Java platform provides the String class to create and manipulate strings.
 String is final and imutable class means you can not not change once created.
 if you do that then another obeject will be create.
*/