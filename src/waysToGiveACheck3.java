import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class waysToGiveACheck3 {

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        int ways = 0;
        int pawnRow = 6; // pawn must start at row 6 (rank 7) if it is going to be promoted
        int pawnColumn = 0;
        int kingRow = 0, kingColumn = 0;
        int breakLoopFlag = 0;
        boolean pawnFound = false;
        //get position of enemy king and position of pawn-to-be-promoted
        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'k') {
                    kingRow = i;
                    kingColumn = j;
                    breakLoopFlag++;
                }
                if (!pawnFound) {
                    if (board[6][j] == 'P') {
                        pawnColumn = j;
                        pawnFound = true;
                        breakLoopFlag++;
                    }
                }
                if (breakLoopFlag == 2) {
                    break outer;
                }
            }
        }

        int promPawnRow = pawnRow + 1;
        int promPawnColumn = pawnColumn;

        //Check to see which kinds of pieces can check the king after pawn promotion
        if (kingRow == promPawnRow || kingColumn == promPawnColumn) { //if the king is in the same row or column as the promoted pawn
            ways += 2; // king can be checked by rook or queen
        } else if ((kingRow == promPawnRow-1 && kingColumn == promPawnColumn - 2) ||
                (kingRow == promPawnRow-1  && kingColumn == promPawnColumn + 2) ||
                (kingRow == promPawnRow-2 && kingColumn == promPawnColumn - 1) ||
                (kingRow == promPawnRow-2 && kingColumn == promPawnColumn + 1)) { //if the king is in range of a knight
            ways += 1; // king can be checked by knight
        } else {

            //Determine if the king is diagonal to the promoted pawn. If so, the king can be checked by a bishop or a queen
            //test diagonals to the left
            boolean checkKingOnLeftDiagonal = false;
            for (int i = promPawnRow - 1; i > 0; i--) {
                for (int j = promPawnColumn - 1; j > 0; j--) {
                    if (i == kingRow && j == kingColumn) {
                        //ways += 2; // king can be checked by bishop and queen
                        checkKingOnLeftDiagonal = true;
                        break;
                    }
                }
            }

            //test diagonals to the right
            boolean checkKingkOnRightDiagonal = false;
            for (int i = promPawnRow - 1; i > 0; i--) {
                for (int j = promPawnColumn + 1; j < 8; j++) {
                    if (i == kingRow && j == kingColumn) {
                        checkKingkOnRightDiagonal = true;
                        break;
                        //ways += 2; // king can be checked by bishop and queen
                    }
                }
            }

            if (checkKingOnLeftDiagonal || checkKingkOnRightDiagonal) {
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
            for (int board_i = 7; board_i >= 0; board_i--) {
                rank = in.nextLine();
                //System.out.println(rank);
                for (int board_j = 0; board_j < 8; board_j++) {
                    //board[board_i][board_j] = in.next().charAt(0);
                    board[board_i][board_j] = rank.charAt(board_j);
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }
}
