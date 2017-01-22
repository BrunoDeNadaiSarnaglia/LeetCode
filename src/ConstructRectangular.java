/**
 * Created by Sarnaglia on 1/22/17.
 */
public class ConstructRectangular {


    public int[] constructRectangle(int area) {
        int W = (int) Math.floor(Math.sqrt(area));
        if(W * W == area)   return new int[]{W, W};
        int L = W + 1;
        while (W * L != area){
            if(W * L < area) {
                L++;
            } else {
                W--;
            }
        }
        return new int[]{L, W};
    }

}
