import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
  Cubes and Cylinders
 */
public class CubesAndCylinders {


    /*
     * Complete the function below.
     */
    static int maximumPackages(int[] S, int[] K, int[] R, int[] C, int m, int n) {
        // Return the maximum number of packages that can be put in the containers.
        int maxNum = 0;
        int[] packagesInCylinder = new int[C.length];
        /*Arrays.sort(S);
        Arrays.sort(K);
        Arrays.sort(R);
        Arrays.sort(C);*/
        //copies = K[0];
        for (int i = 0; i < K.length /*&& i < K[i]*/; i++){ // for a given number of package copies

            //int packagesInCylinder = 0;   // assume the cylinder is not full yet
            int packageCopiesRemaining = 0;
            packageCopiesRemaining += K[i];   // number of copies of the ith package
            // for a given cylinder radius
            inner:
            for (int j = 0; j < R.length && packageCopiesRemaining > 0; j++){
                if(S[i] <= R[j]){
                    // while the cylinder is not full and there are more copies of the package
                    while(packagesInCylinder[j] < C[j] && packageCopiesRemaining > 0){
                        maxNum++;
                        packagesInCylinder[j]++;
                        packageCopiesRemaining--;
                    }
                }
            }
        }
        return maxNum;


    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }*/

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());
        int m = Integer.parseInt(nm[1].trim());

        int SSize = n /*Integer.parseInt(scan.nextLine().trim())*/;

        int[] S = new int[SSize];

        String[] SItems = scan.nextLine().split(" ");

        for (int SItr = 0; SItr < SSize; SItr++) {
            int SItem = Integer.parseInt(SItems[SItr].trim());
            S[SItr] = SItem;

        }

        int KSize = n /*Integer.parseInt(scan.nextLine().trim())*/;

        int[] K = new int[KSize];

        String[] KItems = scan.nextLine().split(" ");

        for (int KItr = 0; KItr < KSize; KItr++) {
            int KItem = Integer.parseInt(KItems[KItr].trim());
            K[KItr] = KItem;

        }

        int RSize = m /*Integer.parseInt(scan.nextLine().trim())*/;

        int[] R = new int[RSize];

        String[] RItems = scan.nextLine().split(" ");

        for (int RItr = 0; RItr < RSize; RItr++) {
            int RItem = Integer.parseInt(RItems[RItr].trim());
            R[RItr] = RItem;

        }

        int CSize = m /*Integer.parseInt(scan.nextLine().trim())*/;

        int[] C = new int[CSize];

        String[] CItems = scan.nextLine().split(" ");

        for (int CItr = 0; CItr < CSize; CItr++) {
            int CItem = Integer.parseInt(CItems[CItr].trim());
            C[CItr] = CItem;

        }

        int result = maximumPackages(S, K, R, C, m, n);
        System.out.println(result);

        /*bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();*/
    }
}
