/**
 * Created by Sarnaglia on 7/1/17.
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        CanPlaceFlowers c =new CanPlaceFlowers();
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
        System.out.println(c.canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{0,0,1,0,1,0}, 2));
        System.out.println(c.canPlaceFlowers(new int[]{0,0,1,0,1,0,0}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = -2;
        int count = 0;
        for (int j = 0; j < flowerbed.length; j++) {
            if(flowerbed[j] == 1) {
                count += (j - i - 2) / 2;
                i = j;
            }
        }
        count += (flowerbed.length + 1 - i - 2) / 2;
        return count >= n;
    }

}
