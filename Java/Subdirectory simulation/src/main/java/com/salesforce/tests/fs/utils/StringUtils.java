package com.salesforce.tests.fs.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    
    public static List<String> readLinesToArrayList(String[] inputLines) {
        return new ArrayList(Arrays.asList(inputLines));
    }
    
    public static String[] listToStringArray(List<String> lines) {
        String[] output = new String[lines.size()];
        int i = 0;
        for(String s : lines)
        {
            output[i++] = (String)s;
        }
        return output;
    }
    
}
