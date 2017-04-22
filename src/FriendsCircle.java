import java.util.HashSet;

/**
 * Created by Sarnaglia on 4/22/17.
 */
public class FriendsCircle {

    public static void main(String[] args){
        FriendsCircle fc = new FriendsCircle();
        fc.findCircleNum(new int[][]{
                new int[]{1,1,0},
                new int[]{1,1,0},
                new int[]{0,0,1}
        });
    }

    public int findCircleNum(int[][] M) {
        boolean[] dfsFriend = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < dfsFriend.length; i++) {
            if(!dfsFriend[i]){
                dfs(M, i, dfsFriend);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int i, boolean[] dfsFriend){
        if(dfsFriend[i])    return;
        dfsFriend[i] = true;
        for (int j = 0; j < M[i].length; j++) {
            if(M[i][j] == 1){
                dfs(M, j, dfsFriend);
            }
        }
    }
}
