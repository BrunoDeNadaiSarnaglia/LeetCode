import java.util.*;

/**
 * Created by Bruno on 8/9/2016.
 */
public class RandomizedCollection {

    public static void main(String[] args){
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(0);
        System.out.println(randomizedCollection.mapToIdx.size());
        randomizedCollection.remove(0);
        System.out.println(randomizedCollection.mapToIdx.size());
        randomizedCollection.insert(-1);
        System.out.println(randomizedCollection.mapToIdx.size());
        randomizedCollection.remove(0);
        System.out.println(randomizedCollection.mapToIdx.size());
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
        randomizedCollection.getRandom();
    }

    private class ElasticArray {

        int[] array;
        int last;

        public ElasticArray() {
            this.array = new int[1];
            this.last = 0;
        }

        public void insert(int val){
            if(last + 1 >= array.length){
                this.array = doubleSize();
            }
            this.array[last++] = val;
        }

        public void update(int idx, int val){
            this.array[idx] = val;
        }

        private int[] doubleSize(){
            int[] doubleSize = new int[2 * this.array.length];
            for (int i = 0; i < last; i++) {
                doubleSize[i] = this.array[i];
            }
            return doubleSize;
        }

        public int length(){
            return last;
        }

        public int get(int idx){
            return this.array[idx];
        }

        public void deleteLast(){
            this.last = (--this.last < 0 ? 0 : this.last);
        }
    }

    private ElasticArray elasticArray;
    private HashMap<Integer, LinkedHashSet<Integer>> mapToIdx;
    private java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.elasticArray = new ElasticArray();
        mapToIdx = new HashMap<Integer, LinkedHashSet<Integer>>();
    }

    private boolean contains(int val){
        return mapToIdx.containsKey(val);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        this.elasticArray.insert(val);
        LinkedHashSet<Integer> set = mapToIdx.getOrDefault(val, new LinkedHashSet<Integer>());
        set.add(this.elasticArray.length() - 1);
        mapToIdx.put(val, set);
        return true;
    }

    /** Deletes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!contains(val)) {
            return false;
        }
        LinkedHashSet<Integer> set = mapToIdx.get(val);
        int idx = set.iterator().next();
        int lastIdx = this.elasticArray.length() - 1;
        int lastVal = this.elasticArray.get(lastIdx);
        this.elasticArray.update(idx, lastVal);
        this.elasticArray.deleteLast();
        set.remove(idx);
        LinkedHashSet<Integer> list = mapToIdx.get(lastVal);
        list.add(idx);
        list.remove(lastIdx);
        if(set.isEmpty()) mapToIdx.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(this.elasticArray.length());
        return this.elasticArray.get(idx);
    }
}
