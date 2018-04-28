
/* A program that finds maximum permutations*/
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution9 {


    /*
     * Complete the function below.
     */
    static String maximumPermutation(String w, String s) {
        // Return the string representing the answer.
        String answer = "answer";
        HashMap alphabet = new HashMap(26);

        for(char c = 'a'; c <= 'z'; c++){
            int occurrences = 0;
            for (int i = 0; i < w.length(); i++){
                if(c == w.charAt(i)){
                    occurrences++;
                }
            }
            alphabet.put(c, occurrences);
        }

        for(int i = 0; i < w.length(); i++){
            System.out.println(w.charAt(i) + " occurs " + alphabet.get(w.charAt(i)) + " times.");
        }





        /*int[] letterCounts = new int[];
        for(int i = 0; i+1 < w.length(); i++){
            for(int j = w.length()-1; j >= 0; j--){
                if(w.charAt(i) == w.charAt(j)){
                    letterCounts[i]++;
                }
            }

        }*/

        return answer;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       /* BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }*/

        //int t = Integer.parseInt(scan.nextLine().trim());
        int t = scan.nextInt();
        scan.nextLine();
        for (int t_i = 0; t_i < t; t_i++) {
            String w = scan.nextLine();

            String s = scan.nextLine();

            String result = maximumPermutation(w, s);

           // bw.write(result);
            //bw.newLine();
            System.out.println(result);

        }

        //bw.close();
    }
}
