/**
 * Created by Sarnaglia on 4/30/17.
 */
public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0 || nums[0].length == 0) return nums;
        if(nums.length * nums[0].length != r * c)   return nums;
        int[][] matrixReshaped = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                matrixReshaped[(i * nums[0].length + j) / c][(i * nums[0].length + j) % c] = nums[i][j];
            }
        }
        return matrixReshaped;
    }

}
