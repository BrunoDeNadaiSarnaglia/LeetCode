import java.util.HashMap;

/**
 * Created by Bruno on 5/4/2016.
 */
public class bitCounter {

    public int[] CountBits(int num) {
        HashMap<Integer, Integer> map = numBits(num);
        int[] countArray = new int[num + 1];
        for(int i = 0; i <= num; i++){
            countArray[i] = map.get(i);
        }
        return countArray;
    }

    private HashMap<Integer, Integer> numBits(int num){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        return numBits(1, num, map);
    }

    private HashMap<Integer, Integer> numBits(int max, int num, HashMap<Integer, Integer> map){
        if(max > num) return map;
        HashMap<Integer, Integer> mapUpperHalf = new HashMap<Integer, Integer>();
        for(Integer number : map.keySet()){
            mapUpperHalf.put(number & max, map.get(number) + 1);
        }
        map.putAll(mapUpperHalf);
        return numBits(max >> 1, num, map);
    }



}
