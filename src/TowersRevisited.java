import java.io.*;
import java.util.*;

public class TowersRevisited {

    public static int whoWins(int[] towers){
        int winner = 0;
        //int x;
        //int y;
        //int z;
        //int whoseTurn = 1; // is it player 1's turn or player 2's turn? Player 1 starts first      
        boolean playerOneTurn = true;
        int validMovesRemaining = towers.length; // start game assuming all towers in array can be broken                                                      down. Therefore all elements are valid moves
        Arrays.sort(towers);
        if((towers.length == 1 && towers[0] == 1) || towers.length > 1 && towers[towers.length-1] == 1){ // if all the towers are                                                                                                              // already of height 1
            winner = 2; // player 1 cannot make a valid move, so player 2 wins by default
        }else{
            //int currentIndex;
            for (int i = 0; i < towers.length; i++){
                if(towers[i] > 1){ // if the given tower can be broken down to towers of height 1
                    validMovesRemaining--; //break it down and decrement number of valid moves

                    playerOneTurn = !playerOneTurn; // now it's the next player's move
                }
            }

            if(playerOneTurn){ // if it's player 1's move and there are no more valid moves to make
                winner = 2; // then player 2 is the winner
            }else{
                winner = 1; // otherwise player 1 is the winner
            }
        }




        //Arrays.sort(towers);
        
        /*if (towers[towers.length-1] >= ){
            winner = 1;
        }else if (towers[towers.length-1] == 3){
            winner = 2;
        }*/
        return winner;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++){
            int n = scan.nextInt();
            int[] towers = new int[n];
            for (int j = 0; j < n; j++){
                towers[j] = scan.nextInt();
            }
            System.out.println(whoWins(towers));
        }
        scan.close();
    }
}