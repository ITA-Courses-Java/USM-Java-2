package com.vctrmrcnsk.first_maven;
import org.apache.commons.lang3.StringUtils;
public class Grep {
	/* checks if given token contains the search string and prints it, if true */
	public static void printMatch(String token, String search) {
		if (StringUtils.contains(token, search))
			System.out.println(token);
	}
}
