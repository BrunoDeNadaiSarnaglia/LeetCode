import java.util.*;

/**
 * Created by Bruno on 10/5/2016.
 */
public class DiceSum {

    public static void main(String[] args){
        DiceSum s = new DiceSum();
        s.dicesSum(15);
    }

    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        HashMap<Integer, Long> map = dicesSumHelper(n);
        System.out.print(map);
        HashMap<Integer, Double> ans = new HashMap<Integer, Double>();
        long sum = 0;
        for (Long count : map.values()){
            sum += count;
        }
        for (Map.Entry<Integer, Long> entry : map.entrySet()){
            if(entry.getValue() == 0)   continue;
            ans.put(entry.getKey(), (double)entry.getValue()/ (double)sum);
        }
        List<Map.Entry<Integer, Double>> l = new ArrayList<Map.Entry<Integer, Double>>();
        for (Map.Entry<Integer,Double> entry : ans.entrySet()){
            l.add(entry);
        }
        Collections.sort(l, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        return l;
    }



    public HashMap<Integer, Long> dicesSumHelper(int n) {
        if(n == 0){
            HashMap<Integer, Long> map = new HashMap<Integer, Long>();
            map.put(0,new Long(1));
            return map;
        }
        HashMap<Integer, Long> map = dicesSumHelper(n - 1);
        HashMap<Integer, Long> mapAux = new HashMap<Integer, Long>();
        for (int i = 1; i <= 6; i++) {
            for (Integer sum : map.keySet()){
                mapAux.put(sum + i, (mapAux.containsKey(sum + i) ? mapAux.get(sum + i) : 0) + map.get(sum));
            }
        }
        return mapAux;
    }
}
