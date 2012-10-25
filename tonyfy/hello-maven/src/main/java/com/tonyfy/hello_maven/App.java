package com.tonyfy.hello_maven;

import org.apache.commons.lang3.StringUtils;

public class App {

    public static void main(String[] args) {
        String hello = "Hello World!";

        System.out.println(StringUtils.replace(hello, "World", "Maven"));
    }

}
