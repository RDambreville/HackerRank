import java.util.Scanner;

public class RevisedRussianRoulette {

    /*static int[] revisedRussianRoulette(int[] doors){
        int min =0;
        int max =0;
        int[] maxAndMin = new int[2];
        for (int i = 0; i + 1 < doors.length; i++){
            if (doors[i] == 1 && doors[i + 1] == 1){
                min++;
                max += 2;
                i++;
            }
        }
        maxAndMin[0] = min;
        maxAndMin[1] = max;
        return maxAndMin;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] doors = new int[t];
        in.nextLine();
            //char[][] board = new char[8][8];
            //board[0][0] = in.next().charAt(0);
            //System.out.println(board[0][0]);

            String input;
            input = in.nextLine();
                //System.out.println(rank);
                for (int i = 0; i < input.length(); i++) {
                    //board[board_i][board_j] = in.next().charAt(0);
                    //board[board_i][board_j] = rank.charAt(board_j);
                    doors[i] = Integer.parseInt(input.substring(i, i+1));

                }

            int[] result = revisedRussianRoulette(doors);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        in.close();
    }*/

    static int[] revisedRussianRoulette(int[] doors) {
        // Complete this function
        int min =0;
        int max =0;
        int[] maxAndMin = new int[2];
        if(doors.length == 1 && doors[0] == 1){
            min++;
            max = 1;
        }else if (doors.length == 1 && doors[0] != 1){
            min = 0;
            max = 0;
        }else{
            for (int i = 0; i + 1 < doors.length; i++){
                if (doors[i] == 1 && doors[i + 1] == 1){
                    min++;
                    max += 2;
                    i++;
                }else if (doors[i] == 1 && doors[i + 1] == 0){
                    min++;
                    max += 1;
                    i++;
                }else if (doors[i] == 0 && doors[i + 1] == 1){
                    min++;
                    max += 1;
                    i++;
                }else if (doors[i] == 0 && doors[i + 1] == 0){
                    min += 0;
                    max += 0;
                    i++;
                }
            }
        }
        maxAndMin[0] = min;
        maxAndMin[1] = max;
        return maxAndMin;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
