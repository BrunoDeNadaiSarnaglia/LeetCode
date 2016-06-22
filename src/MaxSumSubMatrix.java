import java.util.TreeSet;

/**
 * Created by Bruno on 6/21/2016.
 */
public class MaxSumSubMatrix {

    public static void main(String[] args){
        MaxSumSubMatrix a = new MaxSumSubMatrix();
        int v = a.maxSumSubmatrix(new int[][]{new int[]{-1,0,1}, new int[]{0, -2, 3}}, 2);
        System.out.print(v);
        v = a.maxSumSubmatrix(new int[][]{new int[]{2,2,-1}}, 0);
        System.out.print(v);
    }

    private int[][] transpose(int[][] matrix){
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        if(matrix.length < matrix[0].length)    return maxSumSubmatrix(transpose(matrix), k);
        int[][] sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sumMatrix[i + 1][j + 1] = sumMatrix[i + 1][j] + sumMatrix[i][j + 1] - sumMatrix[i][j] + matrix[i][j];
            }
        }
        int diff = Integer.MIN_VALUE;
        for (int j = 0; j <= matrix[0].length; j++) {
            for (int i = 0; i < j; i++) {
                int[] array = new int[matrix.length + 1];
                for (int l = 0; l < sumMatrix.length; l++) {
                    array[l] = sumMatrix[l][j] - sumMatrix[l][i];
                }
                diff = Math.max(diff, arrayModSubSum(array, k));
            }
        }
        return diff;
    }

    private int arrayModSubSum(int[] array, int k){
//        Utils.printArray(array);
        TreeSet<Integer> set = new TreeSet<Integer>();
        Integer diff = null;
        for (int i = 0; i < array.length; i++){
//            k >= b - a | a >= b - k
            Integer value = set.ceiling(array[i] - k);
            if(value == null){
                set.add(array[i]);
                continue;
            }
            if(diff == null) diff = array[i] - value;
            else diff = Math.max(diff, array[i] - value);
            set.add(array[i]);
        }
        return (diff == null ? Integer.MIN_VALUE : diff);
    }
}
