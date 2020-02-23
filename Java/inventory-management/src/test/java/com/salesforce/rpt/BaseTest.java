package com.salesforce.rpt;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Base Test to redirect stdin and stdout to test
 */
public class BaseTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().muteForSuccessfulTests().enableLog();


    protected void runTest(String expectedOutput, String input) {
        systemInMock.provideLines(input.split("\\n"));
        Solution.main(new String[0]);
        String actualOutput = systemOutRule.getLogWithNormalizedLineSeparator();
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
