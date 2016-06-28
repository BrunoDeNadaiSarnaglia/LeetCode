import java.util.*;

/**
 * Created by Bruno on 6/28/2016.
 */
public class WaterAndJug {

    public static void main(String[] args){
        WaterAndJug a = new WaterAndJug();
        System.out.println(a.canMeasureWater(13,11,1));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0)  return true;
        if(x == 0 && y == 0)  return false;
        if((x == 0 || y == 0) && z == Math.max(x, y)) return true;
        if(x == 0 || y == 0) return false;
        int diff = Math.max(x, y) % Math.min(x, y);
        HashSet<Integer> set = modSet(Math.min(x, y), diff);
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        pq.add(0);
//        while(!pq.isEmpty()){
//            int val = pq.peek();
//            if(val == z) return true;
//            if(val > z) return false;
//            while(!pq.isEmpty() &&  val == pq.peek()) pq.poll();
//            for (Integer mod : set) {
//                pq.add(val + mod);
//            }
//        }
        return set.contains(z - x) || set.contains(z - y) || z == x || z == y || set.contains(z);
    }

    private HashSet<Integer> modSet(int value, int diff){
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(value);
        int it = value;
        while(true){
            it = (it - diff + value) % value;
            if(set.contains(it) || it == 0)    break;
            set.add(it);
        }
        System.out.println(set);
        return set;
    }
}
