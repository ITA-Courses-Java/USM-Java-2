package MavenProj.MavenProject;
import org.apache.commons.lang3.StringUtils;

public class extndString {

	String swapC(String str)
	{
		return StringUtils.swapCase(str);
	}
	
	
	String subTag(String str)
	{
		
		return StringUtils.substringBetween(str, "<body>", "</body>");
	}
	
	String[] splitText(String text)
	{
		return StringUtils.split(text,".");
		
	}
}
