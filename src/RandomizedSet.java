import java.util.HashMap;

/**
 * Created by Bruno on 8/3/2016.
 */
public class RandomizedSet {

    public static void main(String[] args){
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        System.out.println(set.getRandom());
        set.remove(1);
        set.insert(2);
        System.out.println(set.getRandom());
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
    private HashMap<Integer, Integer> mapToIdx;
    private java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.elasticArray = new ElasticArray();
        mapToIdx = new HashMap<Integer, Integer>();
    }

    private boolean contains(int val){
        return mapToIdx.containsKey(val);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(contains(val)) return false;
        this.elasticArray.insert(val);
        mapToIdx.put(val, this.elasticArray.length() - 1);
        return true;
    }

    /** Deletes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!contains(val)) return false;
        int idx = mapToIdx.get(val);
        int lastVal = this.elasticArray.get(this.elasticArray.length() - 1);
        this.elasticArray.update(idx, lastVal);
        mapToIdx.put(lastVal, idx);
        this.elasticArray.deleteLast();
        mapToIdx.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(this.elasticArray.length());
        return this.elasticArray.get(idx);
    }
}
