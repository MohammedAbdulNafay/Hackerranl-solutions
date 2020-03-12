package com.salesforce.tests.fs;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * The default test class to be executed always
 */
public class HiddenTest extends BaseTest {

    @Test
    public void testMkdir() throws IOException {
        String[] testInput = {
                "mkdir sub6",
                "mkdir sub6"
        };

        String[] expectedOutput = {
                "Command: mkdir   sub6    \n",
                "Command: mkdir   sub6    \n",
                "Subdirectory already exists\n",
        };

        runTest(testInput, expectedOutput, false);
    }

    @Test
    public void testUp() throws IOException {
        String[] testInput = {
                "up",
        };

        String[] expectedOutput = {
                "Command: up      \n",
                "Cannot move up from root directory\n",
        };

        runTest(testInput, expectedOutput, false);
    }


    @Test
    public void testCD() throws IOException {
        String[] testInput = {
                "dir",
                "mkdir sub6",
                "cd sub6",
                "mkdir sub7",
                "cd sub8",
        };

        String[] expectedOutput = {
                "Command: dir     \n",
                "Directory of root:\n",
                "No subdirectories\n",
                "Command: mkdir   sub6    \n",
                "Command: cd      sub6    \n",
                "Command: mkdir   sub7    \n",
                "Command: cd      sub8    \n",
                "Subdirectory does not exist\n"
        };

        runTest(testInput, expectedOutput, false);
    }

    @Test
    public void testMixedCommands() throws IOException {
        String[] testInput = {
                "mkdir   sub12345",
                "remove"
        };

        String[] expectedOutput = {
                "Command: mkdir   sub12345\n",
                "Invalid command\n"
        };

        runTest(testInput, expectedOutput, false);
    }

    @Test
    public void testDir() throws IOException {
        String[] testInput = {
                "mkdir   sub1",
                "cd      sub1",
                "mkdir   sub2",
                "cd      sub2",
                "mkdir   sub3",
                "cd      sub3",
                "mkdir   sub301",
                "mkdir   sub302",
                "mkdir   sub303",
                "mkdir   sub304",
                "mkdir   sub305",
                "mkdir   sub306",
                "mkdir   sub307",
                "mkdir   sub308",
                "mkdir   sub309",
                "mkdir   sub310",
                "mkdir   sub311",
                "mkdir   sub312",
                "mkdir   sub313",
                "mkdir   sub314",
                "mkdir   sub315",
                "mkdir   sub316",
                "mkdir   sub317",
                "mkdir   sub318",
                "mkdir   sub319",
                "mkdir   sub320",
                "mkdir   sub321",
                "mkdir   sub322",
                "mkdir   sub323",
                "mkdir   sub324",
                "dir",
        };

        String[] expectedOutput = {
                "Command: mkdir   sub1    \n",
                "Command: cd      sub1    \n",
                "Command: mkdir   sub2    \n",
                "Command: cd      sub2    \n",
                "Command: mkdir   sub3    \n",
                "Command: cd      sub3    \n",
                "Command: mkdir   sub301  \n",
                "Command: mkdir   sub302  \n",
                "Command: mkdir   sub303  \n",
                "Command: mkdir   sub304  \n",
                "Command: mkdir   sub305  \n",
                "Command: mkdir   sub306  \n",
                "Command: mkdir   sub307  \n",
                "Command: mkdir   sub308  \n",
                "Command: mkdir   sub309  \n",
                "Command: mkdir   sub310  \n",
                "Command: mkdir   sub311  \n",
                "Command: mkdir   sub312  \n",
                "Command: mkdir   sub313  \n",
                "Command: mkdir   sub314  \n",
                "Command: mkdir   sub315  \n",
                "Command: mkdir   sub316  \n",
                "Command: mkdir   sub317  \n",
                "Command: mkdir   sub318  \n",
                "Command: mkdir   sub319  \n",
                "Command: mkdir   sub320  \n",
                "Command: mkdir   sub321  \n",
                "Command: mkdir   sub322  \n",
                "Command: mkdir   sub323  \n",
                "Command: mkdir   sub324  \n",
                "Command: dir     \n",
                "Directory of root\\sub1\\sub2\\sub3:\n",
                "sub301  sub302  sub303  sub304  sub305  sub306  sub307  sub308  sub309  sub310  \nsub311  sub312  sub313  sub314  sub315  sub316  sub317  sub318  sub319  sub320  \nsub321  sub322  sub323  sub324  \n",
        };

        runTest(testInput, expectedOutput, false);

    }

    @Test
    public void testIfUnitTestsAdded() throws ClassNotFoundException {
        String className = YourUnitTest.class.getName();
        Class c = Class.forName(className);

        for (Method method : c.getDeclaredMethods()) {
            Test testAnno = method.getAnnotation(Test.class);
            if (testAnno != null) {
                return;
            }
        }

        Assert.fail("You did not add any unit tests in " + className);
    }
}
