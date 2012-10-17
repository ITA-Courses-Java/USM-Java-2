package parser;

import org.apache.commons.lang3.StringUtils;

public class URL {
		private String host, doc, url;
		private int port;
	
	public URL(){
		
	}
		
	public URL(String url){
		
		this.url = url;
		
	}
		
	public String resolve(){

		if (url == null)
			return "Empty URL.";
		/*Trying to find port for few protocols*/
		if(StringUtils.startsWithIgnoreCase(url, "http://"))
			port =  80;
		else if(StringUtils.startsWithIgnoreCase(url, "https://"))
			port = 443;
		else if(StringUtils.startsWithIgnoreCase(url, "https://"))
			port = 21;
		else if(StringUtils.countMatches(url, "://") > 0)
			return "Unknown protocol " + StringUtils.substringBefore(url, "://");
		else	{
			port = 80;
			url = "http://" + url;
		}
		
		/*Host name is contained between protocol and first slash*/
		host = StringUtils.substringBefore(
				StringUtils.substringAfter(url, "://"),
				"/"
				);
		
		/*Doc link is the string that follows the first slash after host name*/
		doc = StringUtils.substringAfter(
				StringUtils.substringAfter(url, "://"),
				"/"
				);
		
		/*Replacing special chars with html notation*/
		doc = HTMLEncode(doc);
		
		/*Forming result string*/
		String result = "HOST: " + host + System.getProperty("line.separator") + 
				"PORT: " + port + System.getProperty("line.separator") + 
				"DOC: " + doc;
		
		return result;
	}
	
	public String HTMLEncode(String str){
		
		String rez = str;
		
		rez = StringUtils.replace(rez, "&", "&amp");
		rez = StringUtils.replace(rez, "\"", "&quot");
		rez = StringUtils.replace(rez, "'", "&apos");
		rez = StringUtils.replace(rez, "<", "&lt");
		rez = StringUtils.replace(rez, ">", "&gt");

		return rez;
		
	}
	
	

}
