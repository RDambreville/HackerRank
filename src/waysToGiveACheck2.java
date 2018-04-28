import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class waysToGiveACheck2 {

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        int ways = 0;
        int pawnRow = 6, pawnColumn = 0;
        int kingRow = 0, kingColumn = 0;
        int breakLoopFlag = 0;

        //get position of enemy king and position of pawn-to-be-promoted
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'k') {
                    kingRow = i;
                    kingColumn = j;
                    breakLoopFlag++;
                }
                if (board[6][j] == 'P') {
                    pawnColumn = j;
                    breakLoopFlag++;
                }
                if (breakLoopFlag == 2) {
                    break;
                }

            }
        }

        //Check to see which kinds of pieces can check the king after pawn promotion
        if (kingRow == pawnRow + 1 || kingColumn == pawnColumn) { // if the king is in the same row or column as the promoted pawn
            ways += 2; // king can be checked by rook or queen
        } else if ((kingRow == 6 && kingColumn == pawnColumn - 2) ||
                (kingRow == 6 && kingColumn == pawnColumn + 2) ||
                (kingRow == 4 && kingColumn == pawnColumn - 1) ||
                (kingRow == 4 && kingColumn == pawnColumn + 1)) { //if the king is in range of a knight
            ways += 1; // king can be checked by knight
        } else {

            //Determine if the king is diagonal to the promoted pawn. If so, the king can be checked by a bishop or a queen
            //test diagonals to the left
            boolean checkKingOnLeftDiagonal = false;
            for (int i = pawnRow - 1; i > 0; i--) {
                for (int j = pawnColumn - 1; j > 0; j--) {
                    if (i == kingRow && j == kingColumn) {
                        //ways += 2; // king can be checked by bishop and queen
                        checkKingOnLeftDiagonal = true;
                    }
                }
            }

            //test diagonals to the right
            boolean checkKingkOnRightDiagonal = false;
            for (int i = pawnRow - 1; i > 0; i--) {
                for (int j = pawnColumn + 1; j < 8; j++) {
                    if (i == kingRow && j == kingColumn) {
                        checkKingkOnRightDiagonal = true;
                        //ways += 2; // king can be checked by bishop and queen
                    }
                }
            }

            if (checkKingOnLeftDiagonal ^ checkKingkOnRightDiagonal) {
                ways += 2; // king can be checked by bishop and queen
            }
        }
        return ways;
        //return board[0][1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int a0 = 0; a0 < t; a0++) {
            char[][] board = new char[8][8];
            //board[0][0] = in.next().charAt(0);
            //System.out.println(board[0][0]);
            String rank;
            for (int board_i = 0; board_i < 8; board_i++) {
                rank = in.nextLine();
                //System.out.println(rank);
                for (int board_j = 0; board_j < 8; board_j++) {
                    //board[board_i][board_j] = in.next().charAt(0);
                    board[board_i][board_j] = rank.charAt(board_j);


                    //System.out.print(board[board_i][board_j]);
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
