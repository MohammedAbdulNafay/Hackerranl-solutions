package com.salesforce.rpt;

import org.junit.Test;

/**
 * Test for sample input and output
 */
public class SampleTest extends BaseTest {

    @Test
    public void testSampleInput() {
        String input = "new Sunglasses01 0.50 3.79\n" +
                "new Towel01 1.47 6.98\n" +
                "new Sunglasses02 0.63 4.29\n" +
                "new Sunblock 1.00 4.98\n" +
                "buy Sunblock 100\n" +
                "sell Sunblock 2\n" +
                "buy Towel01 500\n" +
                "buy Sunglasses01 100\n" +
                "buy Sunglasses02 100\n" +
                "sell Towel01 1\n" +
                "sell Towel01 1\n" +
                "sell Sunblock 2\n" +
                "report\n" +
                "delete Sunglasses01\n" +
                "sell Sunblock 5\n" +
                "new Sunglasses03 0.51 1.98\n" +
                "buy Sunglasses03 250\n" +
                "sell Towel01 5\n" +
                "sell Sunglasses03 4\n" +
                "sell Sunglasses02 10\n" +
                "report\n" +
                "*\n";

        String expectedOutput = "                              INVENTORY REPORT\n" +
                "Item Name          Buy At          Sell At          On Hand          Value\n" +
                "---------          ------          -------          -------          -----\n" +
                "Sunblock             1.00             4.98               96          96.00\n" +
                "Sunglasses01         0.50             3.79              100          50.00\n" +
                "Sunglasses02         0.63             4.29              100          63.00\n" +
                "Towel01              1.47             6.98              498         732.06\n" +
                "------------------------\n" +
                "Total value of inventory                                            941.06\n" +
                "Profit since last report                                             26.94\n" +
                "\n" +
                "                              INVENTORY REPORT\n" +
                "Item Name          Buy At          Sell At          On Hand          Value\n" +
                "---------          ------          -------          -------          -----\n" +
                "Sunblock             1.00             4.98               91          91.00\n" +
                "Sunglasses02         0.63             4.29               90          56.70\n" +
                "Sunglasses03         0.51             1.98              246         125.46\n" +
                "Towel01              1.47             6.98              493         724.71\n" +
                "------------------------\n" +
                "Total value of inventory                                            997.87\n" +
                "Profit since last report                                             39.93\n" +
                "\n";

        runTest(expectedOutput, input);
    }
}
