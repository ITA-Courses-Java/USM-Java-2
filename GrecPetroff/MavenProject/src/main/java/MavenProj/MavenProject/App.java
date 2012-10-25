package MavenProj.MavenProject;


import junit.runner.*;
import junit.framework.TestSuite;
import junit.textui.TestRunner;



public class App 


{

	
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
