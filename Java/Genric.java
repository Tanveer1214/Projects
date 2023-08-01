package Tanveer;
class A<T>
{
	T b;
	public void setvalue(T a)
	{
		b=a;
	}
	public T getvalue()
	{
		return(b);
	}
	
}
public class Genric
{
	public static void main(String args[])
	{
		A<Integer> obj1=new A<Integer>();// if you want store different data type so you have to create new object with data type
		A<String>  obj2=new A<String>();
		A<Double>  obj3=new A<Double>();
		obj1.setvalue(50);
		obj2.setvalue("Tanveer");
		obj3.setvalue(3.1);
		System.out.println(obj1.getvalue()+" "+obj2.getvalue()+" "+obj3.getvalue());
		
		
	}
}

/*
public class Genric
{
	public <T> void fun(T []a)
	{
		for(T i:a)
		System.out.println(i);
	}
	
	public static void main(String args[])
	{
		Genric obj=new Genric();
		String ar[]=new String[]{"Pakistan","India","iran"};
		Integer in[]={10,20,30,40,50};
		obj.fun(ar);
		obj.fun(in);
	}
}
		*/