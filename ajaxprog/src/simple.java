import java.io.*;
public class simple{
	private simple(){
	
	}
static simple s1=new simple();

public static  simple getInstance(){
		
		return s1;
	}
}
class c2{
	public static void main(String args[])
	{
		simple s=simple.getInstance();
		simple s2=simple.getInstance();
		 }
}
class c3{
	public static void main(String z[])
	{
		 simple s2=simple.getInstance();
	}
}