package com.sellenyum.maven_ex;
import org.apache.commons.lang3.StringUtils;


public class App 
{
    public static void main( String[] args )
    {
    	String[] numbers = {"one","two","three","four"};
        System.out.println(StringUtils.join(numbers, ","));
    }
}