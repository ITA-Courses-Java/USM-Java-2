package com.tonyfy.hello_maven;

import junit.framework.TestCase;

public class PathTest extends TestCase {

    public void testJoin() {
        assertEquals("src",
                     Path.join("src"));

        assertEquals("src/test",
                     Path.join("src", "test"));

        assertEquals("USM-Java-2/tonyfy/hello-maven/pom.xml",
                     Path.join("USM-Java-2", "tonyfy", "hello-maven",
                               "pom.xml"));
    }

}
