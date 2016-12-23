/**
 * Created by Bruno on 12/23/2016.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        if(x == y)  return 0;
        return (x % 2 != y % 2 ? 1 : 0) + hammingDistance(x / 2, y / 2);
    }

}
