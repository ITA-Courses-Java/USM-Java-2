package com.mycompany.app.my_app;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	public String trim(String str) {
		return StringUtils.trim(str);
	}
	
    public static void main( String[] args )
    {
        System.out.println(new App().trim("                           Hello World!               "));
    }
}
