/**
 * Created by Bruno on 10/18/2016.
 */
public class CountBattleShip {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(isNewShip(board, i, j))  count++;
            }
        }
        return count;
    }


    private boolean isNewShip(char[][] board, int i, int j){
        if(board[i][j] != 'X')  return false;
        if(i - 1 >= 0 && board[i - 1][j] == 'X')    return false;
        if(j - 1 >= 0 && board[i][j - 1] == 'X')    return false;
        return true;
    }
}
