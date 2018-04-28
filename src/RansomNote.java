import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote {

    public static boolean canRansom(String[] magazine, String[] ransom){
        boolean trueOrFalse = false;
        HashMap<String, Integer> magazineWords = new HashMap();
        HashMap<String, Integer> ransomWords = new HashMap();

        //int magWordCount = 0;
        //int ransWordCount = 0;
        for(String magWord: magazine){
            if(magazineWords.get(magWord) == null){
                magazineWords.put(magWord, 1);
            }else{
                magazineWords.put(magWord, magazineWords.get(magWord)+1);
            }
        }

        for(String ransWord: ransom){
            if(ransomWords.get(ransWord) == null){
                ransomWords.put(ransWord, 1);
            }else{
                ransomWords.put(ransWord, ransomWords.get(ransWord)+1);
            }
        }

        for(String ransWord: ransom){
            if (magazineWords.containsKey(ransWord)
                    && magazineWords.get(ransWord) >= ransomWords.get(ransWord)){
                trueOrFalse = true;
            }else{
                return false;
            }
        }

        return trueOrFalse;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();

        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        System.out.println(canRansom(magazine, ransom) == true ? "Yes" : "No");
    }
}
