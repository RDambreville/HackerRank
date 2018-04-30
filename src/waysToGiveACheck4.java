import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*A program that determines how many different ways a promoted pawn can check the opponent's king.
 The input is a 2-D chess board with various pieces positioned about. It is guaranteed that at least
 one pawn is poised for promotion. Change*/

public class waysToGiveACheck4 {

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        int ways = 0;
        int pawnRow = 6; // pawn must start at row 6 (rank7) if it is going to be promoted to row 7 (rank8)
        int pawnColumn = 0;
        int kingRow = 0, kingColumn = 0;
        int breakLoopFlag = 0; // number to indicate when both the king and pawn have been found
        boolean pawnFound = false;

        //get position of enemy king and position of pawn-to-be-promoted
        outer: // label the outer loop so that it can be broken out of once the king and pawn have been found
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'k') {
                    kingRow = i;
                    kingColumn = j;
                    breakLoopFlag++;
                }
                if (!pawnFound) { // avoid looking for the pawn again once it has been found
                    if (board[6][j] == 'P') {
                        pawnColumn = j;
                        pawnFound = true;
                        breakLoopFlag++;
                    }
                }
                if (breakLoopFlag == 2) {
                    break outer; // break the outer loop to avoid unnecessary work
                }
            }
        }

        int promPawnRow = pawnRow + 1; // advance the rank of the pawn by 1 to denote the promotion
        int promPawnColumn = pawnColumn; // keep the column of the pawn the same because promotion only occurs up and down, not left and right

        //Check to see which kinds of pieces can check the king after pawn promotion

        //If the king is in the same row or column as the promoted pawn
        if ((kingRow == promPawnRow || kingColumn == promPawnColumn) /*&& (there are no obstacles between pawn and king)*/) {
            ways += 2; // presumably, king can be checked by a rook or a queen

            //check for obstacles

            // Check king from left or right

            //from RIGHT
            int kColumn = kingColumn + 1; // temp king column holder
            if (kingRow == promPawnRow && kingColumn < promPawnColumn) { // if king is on same row as pawn but to LEFT of pawn
                while (kColumn < promPawnColumn) { // if still left of pawn
                    if (board[kingRow][kColumn] != '#') { // if there's an obstacle between king and pawn, king cannot be checked
                        ways = 0; // king cannot be checked
                        break;
                    } else {
                        kColumn++;
                    }
                }

            //from LEFT
            } else if (kingRow == promPawnRow && kingColumn > promPawnColumn) {
                kColumn = kingColumn - 1;
                while (kColumn > promPawnColumn) { // if still right of pawn
                    if (board[kingRow][kColumn] != '#') { // if there's an obstacle between king and pawn, king cannot be checked
                        ways = 0; // king cannot be checked
                        break;
                    } else {
                        kColumn--;
                    }
                }
            }

            // Check king from above or below
            int kRow = kingRow + 1;

            //from ABOVE
            if (kingColumn == promPawnColumn && kingRow < promPawnRow) {
                while (kRow < promPawnRow) {
                    if (board[kRow][kingColumn] != '#') {
                        ways = 0;
                        break;
                    } else {
                        kRow++;
                    }
                }
                // no need to check from below; pawn can only check from above after being promoted
            /*/from BELOW
            }else if(kingColumn == promPawnColumn && kingRow > promPawnRow){
                kRow = kingRow-1;
                while(kRow > promPawnRow){
                    if(board[kRow][kingColumn] != '#'){
                        ways = 0;
                        break;
                    }else{kRow--;}
                }
            }*/
            }


                // Check king with a knight
            } else if ((kingRow == promPawnRow - 1 && kingColumn == promPawnColumn - 2) ||
                    (kingRow == promPawnRow - 1 && kingColumn == promPawnColumn + 2) ||
                    (kingRow == promPawnRow - 2 && kingColumn == promPawnColumn - 1) ||
                    (kingRow == promPawnRow - 2 && kingColumn == promPawnColumn + 1)) { //if the king is in range of a knight
                ways += 1; // king can be checked by knight


            } else {
                //Check king diagonally
                //Determine if the king is diagonal to the promoted pawn. If so, the king can be checked by a bishop or a queen

                //test left diagonal
                boolean checkKingOnLeftDiagonal = false;
                outer:
                for (int i = promPawnRow - 1; i > 0; i--) { // to be diagonal to pawn, king has to be at least 1 square below pawn. Keep moving down 1 row until king is found
                    for (int j = promPawnColumn - 1; j > 0; j--) { // starting one column to the left of pawn, keep going left
                        if (i == kingRow && j == kingColumn) { // if king is on left diagonal
                            checkKingOnLeftDiagonal = true; // king can be checked by bishop or queen
                            break outer;
                        }
                    }
                }
                //traverse left diagonal again to look for obstacles
                outer:
                for (int i = promPawnRow - 1; i > 0; i--) {
                    for (int j = promPawnColumn - 1; j > 0; j--) {
                        if ((i > kingRow && j > kingColumn) && board[i][j] != '#') {
                            checkKingOnLeftDiagonal = false; // king cannot be checked by bishop or queen
                            break outer;
                        }
                    }
                }


                //test right diagonal
                boolean checkKingkOnRightDiagonal = false;
                outer:
                for (int i = promPawnRow - 1; i > 0; i--) { // to be diagonal to pawn, king has to be at least 1 square below pawn. Keep going down
                    for (int j = promPawnColumn + 1; j < 8; j++) { // starting one column to the right of pawn, keep going right
                        if (i == kingRow && j == kingColumn) { // if king is on right diagonal
                            checkKingkOnRightDiagonal = true; // king can be checked by bishop or queen
                            break outer;
                        }
                    }
                }
                //traverse right diagonal again to look for obstacles
                outer:
                for (int i = promPawnRow - 1; i > 0; i--) {
                    for (int j = promPawnColumn + 1; j < 8; j++) {
                        if ((i > kingRow && j < kingColumn) && board[i][j] != '#') {
                            checkKingkOnRightDiagonal = false; // king cannot be checked by bishop or queen
                            break outer;
                        }
                    }
                }


                if (checkKingOnLeftDiagonal || checkKingkOnRightDiagonal) { // if king is on either diagonal
                    ways += 2; // king can be checked by bishop or queen
                }
            }

            return ways;
        }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int a0 = 0; a0 < t; a0++) {
            char[][] board = new char[8][8];
            String rank;
            for (int board_i = 7; board_i >= 0 ; board_i--) { // read from the top row going downwards
                rank = in.nextLine();
                for (int board_j = 0; board_j < 8; board_j++) { // read from the leftmost column moving right
                    board[board_i][board_j] = rank.charAt(board_j);
                }
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }
}
