import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution5 {

    static long raceAgainstTime(/*int n, int mason_height,*/ int[] heights, int[] prices) {
        // Complete this function
        long sum = 0;
        long places = 0;
        long totalExchangeTime = 0;
        long totalPriceCharged = 0;
        int temp;
        for(int i = 0; i < heights.length-1; i++){
            if(heights[i] > heights[i+1]){
                // swawp the taller height with the shorter one so that the
                // taller one is now in front of the shorter one
                temp = heights[i+1];
                heights[i+1] = heights[i];
                heights[i] = temp;

                places++;
                i++;
                while(i < heights.length-1){
                    if(heights[i] > heights[i+1]){
                        // keep swapping the taller height with the shorter one so that the
                        // taller one is now in front of the shorter one
                        temp = heights[i+1];
                        heights[i+1] = heights[i];
                        heights[i] = temp;
                        places++;
                        i++;
                    }else {
                        totalExchangeTime += heights[i + 1] - heights[i];
                        totalPriceCharged += prices[i + 1];
                        places++;
                        i++;
                    }
                }
                //totalExchangeTime += heights[i+1] - heights[i];
                //totalPriceCharged += prices[i+1];

            }else{
                totalExchangeTime += heights[i+1] - heights[i];
                totalPriceCharged += prices[i+1];
                places++;
            }
        }

        sum = places + totalExchangeTime + totalPriceCharged;
        return sum + 1; // add 1 to the sum to indicate the final pass to Madison

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int mason_height = in.nextInt();
        //int[] heights = new int[n-1];
        int[] heights = new int[n];
        heights[0] = mason_height;
        for(int heights_i = 1; heights_i < n; heights_i++){
            heights[heights_i] = in.nextInt();
        }
        //int[] prices = new int[n-1];
        int[] prices = new int[n];
        prices[0] = 0;
        for(int prices_i = 1; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        long result = raceAgainstTime(/*n, mason_height,*/ heights, prices);
        System.out.println(result);
        in.close();
    }
}
