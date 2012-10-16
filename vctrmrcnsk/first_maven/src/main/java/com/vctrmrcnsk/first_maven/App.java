package com.vctrmrcnsk.first_maven;
import java.io.*;
import org.apache.commons.lang3.StringUtils;

/* program behaves like the Linux grep command */

public class App {
    public static void main( String[] args ) throws IOException
    {
    	String ind = ""; /* searched substring */
    	int lncounter = 0; /* number of filled lines */
    	String strvect[] = new String[1000]; /* input lines go here; array of 1000 Strings */
    	
    	System.out.print("Please give the substring to search for: ");
    	BufferedReader str_container = new BufferedReader(new InputStreamReader(System.in));
		ind = str_container.readLine();
		System.out.println("Please give the lines one by one; will stop at first empty");
		/* reading lines, until an empty one is encountered or max array index reached */
    	for (int i = 0; i < 1000; i++, lncounter++ ) {
    		str_container = new BufferedReader(new InputStreamReader(System.in));
    		strvect[i] = str_container.readLine();
    		if (StringUtils.isBlank(strvect[i]))
    			break;
    	}
    	System.out.println("Selected lines:\n");
    	for (int i = 0; i < lncounter; i++)
    		Grep.printMatch(strvect[i], ind);		
    }
}
