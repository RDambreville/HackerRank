import java.util.Scanner;

public class ImpressTheBoss {

    static int[] swap(int[] a, int i, int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
        return a;
    }
    static String canModify(int[] a) {
        /*
         * Write your code here.
         */
        StringBuffer yesOrNo = new StringBuffer();
        yesOrNo.append("YES");
        int swapsNeeded = 0;
        //Arrays.sort(a);
        if (a.length == 1) {
            yesOrNo.delete(0, yesOrNo.length());
            yesOrNo.append("YES");
            return (yesOrNo.toString());
        }
        for (int i = 0; i + 1 < a.length; i++) {
            if (a[i] > a[i + 1]) {
                if (swapsNeeded < 1) {
                    yesOrNo.delete(0, yesOrNo.length());
                    yesOrNo.append("YES");
                    //a = swap(a, i, i+1);
                    swapsNeeded++;
                } else {
                    yesOrNo.delete(0, yesOrNo.length());
                    yesOrNo.append("NO");
                    return (yesOrNo.toString());
                }
            }else{
                yesOrNo.delete(0, yesOrNo.length());
                yesOrNo.append("YES");
            }

        }
        return (yesOrNo.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) /*throws IOException*/ {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }
            System.out.println(canModify(arr));
        }
        scan.close();

    }
}


