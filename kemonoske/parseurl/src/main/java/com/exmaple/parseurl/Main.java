package com.exmaple.parseurl;

public class Main {
	
	public static void main(String[] args)	{
		
		if(args.length == 0)
			System.err.println("No arguments passed.");
		
		for(String i : args)
			System.out.println((new URL(i)).resolve());
		
	}

}
