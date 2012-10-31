package MavenProj.MavenProject;

import org.apache.commons.lang3.StringUtils;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class extndStringTest extends TestCase {
	
	public extndStringTest(String TestName)
	{
		super(TestName);
	}

	public void testSwapC(String str) {
		
		assertTrue (new extndString().swapC(str) == str.toLowerCase());
		assertFalse(new extndString().splitText(str) == null);
	}

	public void testSubTag(String str) {
		String result = "My Name is Alex";
		assertTrue( result.equals(new extndString().subTag("<body>My Name is Alex</body>")));
	}

	public void testSplitText(String str) {
		String[] result = null ;
		//result[0]="My name is Alex.";
		//result[1]="I'm from I32.";
		//assertTrue( result[0].equals(new extndString().subTag("My name is Alex.I'm from I32.")));
		assertFalse(new extndString().splitText(str) == null);
	}
	
	  public static void main( String[] args )
	    {
	        System.out.println( "Hello." );
	        TestRunner runner = new  TestRunner();
	        TestSuite suite = new TestSuite();
	       
	        suite.addTest(new extndStringTest("testSplitText"));
	        suite.addTest(new extndStringTest("testSubTag"));
	        suite.addTest(new extndStringTest("testSwapC"));
	       runner.doRun(suite);
	    }

}
