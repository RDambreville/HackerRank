import java.util.*;
public class BitwiseAnd {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a = 0; a < t; a++){
            int n = scanner.nextInt();
            int[] set = new int[n]; // set of integers that will be "and-ed"
            //int[] ands = new int[n]; // set of "and" values
            ArrayList<Integer> ands = new ArrayList<>();
            ands.clear();
            ands.trimToSize();

            //populate the set of integers that will be "and-ed"
            for (int b = 0; b < n; b++){
                set[b] = b+1;
            }
            int k = scanner.nextInt();
            int currentListIndex = 0;
            //calculate and store the "and" values
            for (int c = 0; c < n; c++){// move the low forward by 1 after every iteration
                for (int d = n-1; d > c; d--){// move the high backward by 1 after every iteration
                    //if (!((c + 1) > n)){
                    //ands[c] = set[c] & set[d];
                    //int and = set[c] & set[d];

                    if(!ands.isEmpty()) { // if the list is not empty
                        if ((set[c] & set[d]) >= ands.get(currentListIndex).intValue()) { // if this "and-ed" value is greater than the current value in the list
                            ands.add(Integer.valueOf(set[c] & set[d])); // add it to the right of the current value
                            currentListIndex++;
                        } else if ((set[c] & set[d]) < ands.get(currentListIndex).intValue()) { // otherwise if it is less than the current value
                            //Integer temp = ands.get(c); // store the current value in a temporary variable
                            int prevIndex = currentListIndex;
                            while(prevIndex > 0 && (set[c] & set[d]) < ands.get(prevIndex).intValue()){
                                prevIndex--;
                            }
                            ands.add(prevIndex, Integer.valueOf(set[c] & set[d])); // store this "and-ed" value at the current index
                            currentListIndex++;
                            //ands.add(temp); // add the original value to the right ---> this accomplishes the task of switching the order of the two values
                        }
                    }else{ // otherwise if the list is empty
                        ands.add(Integer.valueOf(set[c] & set[d])); // store this "and-ed" value at the beginning of the list

                    }


                }

            }
            /*int[] andsArray = new int[ands.size()];
            for (int i = 0; i < ands.size(); i++){
                andsArray[i] = ands.get(i).intValue();
            }*/

            /*Arrays.sort(andsArray);
            for (int e = andsArray.length-1; e >= 0; e--){
                if (andsArray[e] < k){
                    System.out.println(andsArray[e]);
                    break;
                }
            }*/


            for (int e = ands.size()-1; e >= 0; e--){
                if (ands.get(e).intValue() < k){
                    System.out.println(ands.get(e).intValue());
                    break;
                }
            }


        }

    }

}
