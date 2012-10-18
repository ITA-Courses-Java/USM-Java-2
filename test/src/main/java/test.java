import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class test {
     public static void main(String a[]) throws IOException{
    	 String str = "";
    	 String str1 = "";
        	 BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
         System.out.println("Introduceti un string: ");
         str = sc.readLine();
         System.out.println("Introdu un string pentru replace: ");
         str1 = sc.readLine();
    	 System.out.println("Abreviere: " + StringUtils.abbreviate(str, 4));
    	System.out.println("Replace: " + StringUtils.replace(str, str, str1));
    	 System.out.println("Sterge spatii: " + StringUtils.deleteWhitespace(str));
    	 System.out.println("Egal: " + StringUtils.equals(str, str1));
    	    		 
              }
}
