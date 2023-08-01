public class Builder_Buffer {
	
	public static void main(String[] args) {
	
		String s = "Tanveer_";
        StringBuffer stringBuffer = new StringBuffer(s);

        stringBuffer.append(12);
        stringBuffer.append("sam",0,3);

        stringBuffer.insert(7,"Ali");
        stringBuffer.replace(7,10,"Hussain");
        //stringBuffer.reverse();
        //stringBuffer.delete(1,3);
        stringBuffer.ensureCapacity(50);
        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer);


        StringBuilder stringBuilder = new StringBuilder("Tanveer");
        stringBuilder.append(12);
        stringBuilder.replace(1,3,"aaa");
        //methods are almost same..	
	
	}
	
}
/*
The StringBuffer and StringBuilder classes are used when there is a necessity to make a lot of modifications to Strings of characters.
Unlike Strings, objects of type StringBuffer and String builder can be modified over and over again without leaving behind a lot of new unused objects.

The StringBuilder class was introduced as of Java 5 and the main difference between the StringBuffer and StringBuilder is that StringBuilders methods are not thread safe (not synchronised).
It is recommended to use StringBuilder whenever possible because it is faster than StringBuffer. However, if the thread safety is necessary, the best option is StringBuffer objects.
 */