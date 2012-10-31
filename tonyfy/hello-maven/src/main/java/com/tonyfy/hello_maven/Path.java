package com.tonyfy.hello_maven;

import org.apache.commons.lang3.StringUtils;

public class Path {

    public static String join(String... path) {
        String sep = "/";

        return StringUtils.join(path, sep);
    }

}
