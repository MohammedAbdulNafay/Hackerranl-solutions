package com.salesforce.tests.fs;

import com.salesforce.tests.fs.application.SubdirectoriesApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The entry point for the Test program
 */
public class Solution {

    /**
     * do the work here
     *
     * @param input the input text
     * @return the result
     */
    public String[] doIt(String[] input) throws IOException {

        //TODO: provide the real implementation here
        String[] output;

        SubdirectoriesApplication application = new SubdirectoriesApplication();

        output = application.start(input);

        return output;
    }

    //==================You don't need to change the following codes ==========================//
    public static void main(String[] args) throws IOException {
        Solution theOne = new Solution();

        FileReader reader = null;
        try {
            //read from the input file
            reader = new FileReader(args.length == 1 ? args[0] : "input.txt");

            //do the processing
            String[] output = theOne.doIt(readFromFile(reader));

            //write the output to stdout
            //the output should be one we see in output.txt
            for (String s : output) {
                System.out.println(s);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Read input from the file and convert into a String
     *
     * @param reader Input file
     * @return Input in a String
     * @throws IOException
     */
    private static String[] readFromFile(FileReader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        List<String> words = new ArrayList<String>();
        while (((line = bufferedReader.readLine()) != null) && line.trim().length() > 0) {
            words.add(line);
        }
        return words.toArray(new String[words.size()]);
    }
}
