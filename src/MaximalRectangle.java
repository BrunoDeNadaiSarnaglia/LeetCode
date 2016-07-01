import java.util.Stack;

/**
 * Created by Bruno on 7/1/2016.
 */
public class MaximalRectangle {

    public static void main(String[] args){
        MaximalRectangle mr = new MaximalRectangle();
        mr.maximalRectangle(new boolean[][]{
                new boolean[]{true,true,false,false,true},
                new boolean[]{false,true,false,false,true},
                new boolean[]{false,false,true,true,true},
                new boolean[]{false,false,true,true,true},
                new boolean[]{false,false,false,false,true},
        });
    }
    public int maximalRectangle(boolean[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        int[][] colMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < colMatrix.length; i++){
            colMatrix[i][0] = (matrix[i][0] ? 1 : 0);
        }
        for(int i = 0; i < colMatrix.length; i++){
            for(int j = 1; j < colMatrix[0].length; j++){
                if(!matrix[i][j]){
                    colMatrix[i][j] = 0;
                } else {
                    colMatrix[i][j] = colMatrix[i][j - 1] + 1;
                }
            }
        }
        int max = 0;
        for(int j = 0; j < colMatrix[0].length; j++){
            int[] column = getColumn(colMatrix, j);
            max = Math.max(max, max(maxRectangleArray(column)));
        }
        return max;
    }


    private int[] getColumn(int[][] matrix, int j){
        int[] column = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            column[i] = matrix[i][j];
        }
        return column;
    }

    private int[] maxRectangleArray(int[] skyline){
        int[] maxArray = new int[skyline.length];
        Stack<Integer> stk = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i < skyline.length; i++){
            if(stk.isEmpty()){
                maxArray[i] = skyline[i];
                stk.push(i);
            } else if(skyline[stk.peek()] < skyline[i]){
                maxArray[i] = (i - stk.peek()) * skyline[i];
                stk.push(i);
            } else{
                while(!stk.isEmpty() && skyline[stk.peek()] >= skyline[i]){
                    int j = stk.pop();
                    maxArray[j] += (i - j - 1) * skyline[j];
                }
                maxArray[i] = (i - (stk.isEmpty() ? -1 : stk.peek())) * skyline[i];
                stk.push(i);
            }
        }
        while(!stk.isEmpty()){
            int ini = stk.pop();
            maxArray[ini] += (skyline.length - ini - 1) * skyline[ini];
        }
        return maxArray;
    }

    private int max(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
