/**
 * Created by Sarnaglia on 7/2/17.
 */
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[4][];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        int maxDistanceIdx = 1;
        for (int i = 2; i < 4; i++) {
            if(distanceSqr(points[i], points[0]) > distanceSqr(points[i], points[maxDistanceIdx])){
                maxDistanceIdx = i;
            }
        }
        int[] aux = points[maxDistanceIdx];
        points[maxDistanceIdx] = points[2];
        points[2] = aux;
        int dst = distanceSqr(points[0], points[3]);
        if(dst == 0)    return false;
        for (int i = 0; i < 3; i++) {
            if(distanceSqr(points[i], points[i + 1]) != dst){
                return false;
            }
        }
        for (int i = 1; i <= 4 ; i++) {
            if(!ortogonal(points[i - 1], points[i % 4], points[(i + 1) % 4])){
                return false;
            }
        }
        return true;
    }

    private int distanceSqr(int[] p1, int[] p2) {
        return (int)Math.pow(p1[0] - p2[0], 2) + (int)Math.pow(p1[1] - p2[1], 2);
    }

    private boolean ortogonal(int[] p1, int[] p2, int[] p3) {
        return (p3[0] - p2[0])*(p2[0] - p1[0]) + (p3[1] - p2[1])*(p2[1] - p1[1]) == 0;
    }

}
