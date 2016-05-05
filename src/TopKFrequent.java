import java.util.*;

/**
 * Created by Bruno on 5/5/2016.
 */
public class TopKFrequent {


    public static void main(String[] args){
        TopKFrequent top = new TopKFrequent();
        List<Integer> list = top.topKFrequent(new int[]{1,1, 1,1,2,2,3}, 2);
        System.out.println(list);
    }

    private class Pair<K, T>{
        private K k;
        private T t;
        public Pair(K k, T t){
            this.k = k;
            this.t = t;
        }

        public K getFirst(){
            return this.k;
        }


        public T getSecond(){
            return this.t;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return - o1.getSecond() + o2.getSecond();
            }
        });
        for(Integer key : map.keySet()){
            pq.add(new Pair<Integer, Integer>(key, map.get(key)));
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; !pq.isEmpty() && i < k; i++){
            list.add(pq.poll().getFirst());
        }
        return list;
    }
}
