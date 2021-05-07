import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */

    public static int steadyGene(String gene, int n) {
        // Write your code here
        Map<Character, Integer> geneMap = new HashMap<>();
        geneMap.put('C',0);
        geneMap.put('G',0);
        geneMap.put('A',0);
        geneMap.put('T',0);
        
        for(char c : gene.toCharArray()) 
            geneMap.put(c, geneMap.get(c)+1);
            
        //System.out.println(geneMap);
        
        int limit = n/4, i = 0, j = 0, min = 9999999;
        
        while(i < gene.length() && j < gene.length()) {
            if(!isBalanced(geneMap, limit)) {
                geneMap.put(gene.charAt(j), geneMap.get(gene.charAt(j))-1);
                j++;
            } else {
                geneMap.put(gene.charAt(i), geneMap.get(gene.charAt(i))+1);
                min = Math.min(min, j-i);
                i++;
            }
        }
        
        return min;
    }
    
    public static boolean isBalanced(Map<Character, Integer> geneMap, int limit) {
        return !(geneMap.get('C') > limit || geneMap.get('G') > limit || geneMap.get('A') > limit || geneMap.get('T') > limit);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = Result.steadyGene(gene, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
