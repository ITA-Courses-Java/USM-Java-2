package maven.test_proga;
import java.io.*;
import java.lang.*;

/**
 * Hello world!
 *
 */
public class App// throws IOException
{
	public BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	public static App obj;
	
	App() throws IOException
	{
		String str1;
		System.out.println("Insert new line:");
		str1 = bf.readLine();
		String str2;
		System.out.println("Insert second line:");
		str2 = bf.readLine();
		if(str1.equals(str2))
		{
			System.out.println("2 lines are equals!!!");
		}
		else {
			System.out.println("2 lines are not equals!!!!");
		}
	}
	
    public static void main( String[] args ) throws IOException
    {
    	
        System.out.println( "Hello World!" );
        obj = new App();
    }
}
