package com.exmaple.parseurl;

import org.junit.Assert;
import org.junit.Test;

public class TestURL extends Assert{

	@Test
	public void testHTMLEncode()	{
		
		URL test = new URL();
		/*Our method should be able to replace all special chars*/
		assertEquals("Encode test: ", "&amp&apos&quot&lt&gt", test.HTMLEncode("&'\"<>"));
		
	}
	
	@Test
	public void testResolve(){
		
		URL test = new URL();
		assertEquals("Test empty url: ", "Empty URL.", test.resolve());

		test = new URL("http://mysite.com/doc/link");
		assertEquals("Test simple url: ",
				"HOST: mysite.com" + System.getProperty("line.separator") + 
				"PORT: 80" + System.getProperty("line.separator") + 
				"DOC: doc/link"
				, test.resolve());

		test = new URL("mysite.com/doc/link");
		assertEquals("Test simple url without protocol: ",
				"HOST: mysite.com" + System.getProperty("line.separator") + 
				"PORT: 80" + System.getProperty("line.separator") + 
				"DOC: doc/link"
				, test.resolve());

		test = new URL("smtp://mysite.com/doc/link");
		assertEquals("Test url with unknown protocol: ",
				"Unknown protocol smtp", test.resolve());
		
	}
	
}
