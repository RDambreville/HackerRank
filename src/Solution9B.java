import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution9B {

    public static List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public static void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

    /*
     * Complete the function below.
     */
    static String maximumPermutation(String w, String s) {
        // Return the string representing the answer.
        String answer = "";
        List<String> permutations = permute(w.toCharArray());
        HashMap<String, Integer> permOccurrences = new HashMap(permutations.size());

        /*for (String permutation : permutations){
            int occurrences = 0;
            for(int h = 0; h < s.length(); h++){
                int numOfSpacesRemaining = s.length() - h;
                if(permutation.length() <= numOfSpacesRemaining){
                    String substring = s.substring(h, (h + permutation.length()));
                    if(permutation.equals(substring)){
                        occurrences++;
                        permOccurrences.put(permutation, occurrences);
                    }
                }else{
                    break;
                }
            }

        }*/



         int occurrences = 0;
            for(int h = 0; h < s.length(); h++){
                int numOfSpacesRemaining = s.length() - h;
                if(w.length() <= numOfSpacesRemaining){
                    String substring = s.substring(h, (h + w.length()));
                    /*permOccurrences.containsKey(substring)*/
                    if(permutations.contains(substring) && permOccurrences.get(substring) != null){
                        permOccurrences.put(substring, permOccurrences.get(substring)+1);
                    }else if (permutations.contains(substring) && permOccurrences.get(substring) == null){
                        permOccurrences.put(substring, 1);
                    }
                }else{
                    break;
                }
            }















        if (permOccurrences.isEmpty()){
            answer = "-1";
        }else{
            int maxValueInMap = (int) (Collections.max(permOccurrences.values()));
            for (Map.Entry<String, Integer> entry : permOccurrences.entrySet()) {  // Itrate through hashmap
                if (entry.getValue() == maxValueInMap) {
                    answer = entry.getKey();
                    break;
                    //System.out.println(entry.getKey());     // Print the key with max value
                }
            }
        }


        return answer;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }*/

        int t = Integer.parseInt(scan.nextLine().trim());

        for (int t_i = 0; t_i < t; t_i++) {
            String w = scan.nextLine();

            String s = scan.nextLine();

            String result = maximumPermutation(w, s);
            System.out.println(result);

            //bw.write(result);
            //bw.newLine();

        }

        //bw.close();
    }
}
