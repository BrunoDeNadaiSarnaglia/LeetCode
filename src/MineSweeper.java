import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Sarnaglia on 4/28/17.
 */
public class MineSweeper {

    public static void main(String[] args) {
        MineSweeper ms = new MineSweeper();
        ms.updateBoard(
                new char[][] {
                        new char[] {'E', 'E', 'E', 'E', 'E'},
                        new char[] {'E', 'E', 'M', 'E', 'E'},
                        new char[] {'E', 'E', 'E', 'E', 'E'},
                        new char[] {'E', 'E', 'E', 'E', 'E'}
                },
                new int[]{3,0}
        );
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        HashSet<String> set = new HashSet<>();
        char[][] boardCopy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        updateBoard(board, boardCopy, click, set);
        return boardCopy;
    }
    public void updateBoard(char[][] board, char[][] boardCopy, int[] click, HashSet<String> set) {
        int i = click[0];
        int j = click[1];
        if(set.contains(i + "|" + j)) {
            return;
        }
        if(!inBounds(board, i, j)) {
            return;
        }
        if(board[i][j] == 'M'){
            set.add(i + "|" + j);
            boardCopy[i][j] = 'X';
        }
        else if(hasMineAround(board, i, j) != 0) {
            set.add(i + "|" + j);
            boardCopy[i][j] = (char)hasMineAround(board, i, j);
        } else if(board[i][j] == 'E') {
            set.add(i + "|" + j);
            boardCopy[i][j] = 'B';
            updateBoard(board, boardCopy, new int[]{i + 1, j - 1}, set);
            updateBoard(board, boardCopy, new int[]{i + 1, j}, set);
            updateBoard(board, boardCopy, new int[]{i + 1, j + 1}, set);
            updateBoard(board, boardCopy, new int[]{i, j + 1}, set);
            updateBoard(board, boardCopy, new int[]{i, j - 1}, set);
            updateBoard(board, boardCopy, new int[]{i - 1, j - 1}, set);
            updateBoard(board, boardCopy, new int[]{i - 1, j}, set);
            updateBoard(board, boardCopy, new int[]{i - 1, j + 1}, set);
        }
    }

    private int hasMineAround(char[][] board, int i, int j) {
        int sum = 0;
        for (int k = -1; k <= 1 ; k++) {
            for (int l = -1; l <= 1 ; l++) {
                if(inBounds(board, i + k, j + l) && board[i + k][j + l] == 'M') {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean inBounds(char[][] board, int i, int j){
        return !(i < 0 || i >= board.length || j < 0 || j >= board[0].length);
    }

}
