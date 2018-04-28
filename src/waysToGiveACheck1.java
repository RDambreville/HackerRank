import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class waysToGiveACheck1 {

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        int ways = 0;
        int pawnRow = 0, pawnColumn = 0;
        int kingRow = 0, kingColumn = 0;
        int breakLoopFlag = 0;

        //get position of enemy king and position of pawn-to-be-promoted
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'k'){
                    kingRow = i;
                    kingColumn = j;
                    breakLoopFlag++;
                }
                if(board[0][j] == 'P'){
                    pawnColumn = j;
                    breakLoopFlag++;
                }
                if(breakLoopFlag == 2){
                    break;
                }

            }
        }

        int promPawnRow = pawnRow + 1;
        int promPawnColumn = pawnColumn;

        //Check to see which kinds of pieces can check the king after pawn promotion
        if(kingRow == promPawnRow ^ kingColumn == promPawnColumn){ // if the king is in the same row or column as the promoted pawn
            ways += 2; // king can be checked by rook or queen
        }else if((kingRow == promPawnRow-1  && kingColumn == pawnColumn-2)||
                (kingRow == promPawnRow-1 && kingColumn == pawnColumn+2)||
                (kingRow == promPawnRow-2 && kingColumn == pawnColumn-1) ||
                (kingRow == promPawnRow-2 && kingColumn == pawnColumn+1)){ //if the king is in range of a knight
            ways += 1; // king can be checked by knight
        }else{

            //Determine if the king is diagonal to the promoted pawn. If so, the king can be checked by a bishop or a queen
            //test diagonals to the left
            boolean checkKingOnLeftDiagonal = false;
            for(int i = promPawnRow-1; i > 0; i--){
                for(int j = promPawnColumn-1; j > 0; j--){
                    if(i == kingRow && j == kingColumn){
                        //ways += 2; // king can be checked by bishop and queen
                        checkKingOnLeftDiagonal = true;
                    }
                }
            }

            //test diagonals to the right
            boolean checkKingkOnRightDiagonal = false;
            for(int i = promPawnRow-1; i > 0 ; i--){
                for(int j = promPawnColumn+1; j < 8; j++){
                    if(i == kingRow && j == kingColumn){
                        checkKingkOnRightDiagonal = true;
                        //ways += 2; // king can be checked by bishop and queen
                    }
                }
            }

            if(checkKingOnLeftDiagonal ^ checkKingkOnRightDiagonal){
                ways += 2; // king can be checked by bishop and queen
            }
        }
        return ways;
        //return board[0][1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[2][8];
            //board[0][0] = in.next().charAt(0);
            //System.out.println(board[0][0]);
            for(int board_i = 0; board_i < 2; board_i++){
                for(int board_j = 0; board_j < 8; board_j++){
                    board[board_i][board_j] = in.next().charAt(0);
                    /*char[] charArray = in.next().toCharArray();
                    for(char c : charArray){
                        System.out.print(c + " ");
                    }
                    board[board_i][board_j] = charArray[0];*/
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }
}
