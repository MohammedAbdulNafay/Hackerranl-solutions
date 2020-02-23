package com.salesforce.rpt;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The entry point for the Test program
 */
public class Solution {

    TreeSet<String> inventories = new TreeSet<>();
    TreeMap inventoryDetails = new TreeMap();

    private static DecimalFormat df = new DecimalFormat("0.00");
    private float PROFIT = 0, LOSS = 0;

    //10 spaces between column headers
    static final String COLUMN_SEPARATOR = "          ";

    //Column headers, first column (name) should be left-aligned, rest (numbers) should be right-aligned
    static final String[] COLUMN_HEADERS = {
            "Item Name",
            "Buy At",
            "Sell At",
            "On Hand",
            "Value"
    };

    //Report labels
    static final String REPORT_TITLE = "INVENTORY REPORT";
    static final String LINE_SEPARATOR = "-";
    static final String TOTAL_VALUE_OF_INVENTORY = "Total value of inventory";
    static final String PROFIT_SINCE_LAST_REPORT = "Profit since last report";


    private void printHeaders()
    {
        int length = COLUMN_HEADERS.length;
        for(int i = 0; i < length; i++)
        {
            System.out.print(COLUMN_HEADERS[i]);
            if(i != length - 1)
            {
                System.out.print(COLUMN_SEPARATOR);
            }
        }
    }

    private void printHeaderSeparators()
    {
        int length = COLUMN_HEADERS.length;
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < COLUMN_HEADERS[i].length(); j++)
            {
                System.out.print(LINE_SEPARATOR);
            }
            if(i != length - 1)
            {
                System.out.print(COLUMN_SEPARATOR);
            }
        }
    }

    public void doIt(String input) {
        //todo: provide your implementation here
        String[] inputSplit = input.split(" ");
        String operation = inputSplit[0];
        String item_name;
        float item_cost, item_selling_price;
        int quantity;
        switch(operation)
        {
            case "new" :
                item_name = inputSplit[1];
                item_cost = Float.parseFloat(df.format(Float.parseFloat(inputSplit[2])));
                item_selling_price = Float.parseFloat(inputSplit[3]);

                TreeMap temp = new TreeMap();
                temp.put("Item Name", item_name);
                temp.put("Buy At", item_cost);
                temp.put("Sell At", item_selling_price);
                temp.put("Profit", item_selling_price - item_cost);
                temp.put("Sold", 0);
                temp.put("On Hand", 0);
                temp.put("Value", 0);
                inventoryDetails.put(item_name, temp);
                break;

            case "delete" :
                item_name = inputSplit[1];
                inventories.remove(item_name);
                LOSS = Float.parseFloat(String.valueOf(((TreeMap)inventoryDetails.get(item_name)).get("Value")));
                ((TreeMap)inventoryDetails.get(item_name)).put("On Hand", 0);
                ((TreeMap)inventoryDetails.get(item_name)).put("Value", 0);
                break;

            case "buy" :
                item_name = inputSplit[1];
                quantity = Integer.parseInt(inputSplit[2]);
                inventories.add(item_name);
                ((TreeMap)inventoryDetails.get(item_name)).put("On Hand", ((int)((TreeMap)inventoryDetails.get(item_name)).get("On Hand"))+quantity);
                ((TreeMap)inventoryDetails.get(item_name)).put("Value", df.format((float)((TreeMap)inventoryDetails.get(item_name)).get("Buy At")*(int)((TreeMap)inventoryDetails.get(item_name)).get("On Hand")));
                break;

            case "sell" :
                item_name = inputSplit[1];
                quantity = Integer.parseInt(inputSplit[2]);
                ((TreeMap)inventoryDetails.get(item_name)).put("On Hand", ((int)((TreeMap)inventoryDetails.get(item_name)).get("On Hand"))-quantity);
                ((TreeMap)inventoryDetails.get(item_name)).put("Value", df.format((float)((TreeMap)inventoryDetails.get(item_name)).get("Buy At")*(int)((TreeMap)inventoryDetails.get(item_name)).get("On Hand")));
                ((TreeMap)inventoryDetails.get(item_name)).put("Sold", ((int)((TreeMap)inventoryDetails.get(item_name)).get("Sold")+quantity));
                break;

            case "report" :
                System.out.println(COLUMN_SEPARATOR + COLUMN_SEPARATOR + COLUMN_SEPARATOR + REPORT_TITLE);

                printHeaders();
                System.out.println();

                printHeaderSeparators();
                System.out.println();

                float total = 0, profit = 0;
                Iterator<String> iterator = inventories.iterator();

                while (iterator.hasNext())
                {
                    String name = iterator.next();
                    TreeMap inventoryObject = (TreeMap) inventoryDetails.get(name);

                    System.out.format("%-20s%5.2f%s%7.2f%s%7d%15.2f", inventoryObject.get(COLUMN_HEADERS[0]),
                            inventoryObject.get(COLUMN_HEADERS[1]), COLUMN_SEPARATOR,
                            inventoryObject.get(COLUMN_HEADERS[2]), COLUMN_SEPARATOR,
                            inventoryObject.get(COLUMN_HEADERS[3]),
                            Float.parseFloat((String)inventoryObject.get(COLUMN_HEADERS[4])));

                    total += Float.parseFloat((String) inventoryObject.get("Value"));
                    profit += ((float) inventoryObject.get("Profit")*(int)inventoryObject.get("Sold"));
                    System.out.println();
                }

                for(int i = 0; i < 24; i++)
                {
                    System.out.print(LINE_SEPARATOR);
                }
                System.out.println();

                System.out.format("%-65s%9.2f\n", TOTAL_VALUE_OF_INVENTORY, total);

                profit = Float.parseFloat(df.format(profit - PROFIT - LOSS));
                System.out.format("%-65s%9.2f\n\n", PROFIT_SINCE_LAST_REPORT, profit);

                PROFIT = profit;
                LOSS = 0;
                break;
        }

    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        //read from cmd line
        Scanner scan = new Scanner(System.in);
        while (true) {
            String line = scan.nextLine();

            //continue until we hit '*'
            //please see input.txt for sample input
            if ("*".equals(line)) {
                break;
            }

            //do the work
            //see out.txt for sample output
            solution.doIt(line);
        }
    }
}
