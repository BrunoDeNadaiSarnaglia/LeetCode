import java.util.Random;

/**
 * Created by Bruno on 9/14/2016.
 */
public class ShuffleArray {

    private int[] aux = null;
    private int[] nums;
    private Random rand = new Random();

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (this.aux == null)   clone1();
        for (int i = 0; i < this.aux.length; i++) {
            int randValue = rand.nextInt(i + 1);
            swap(this.aux, i, randValue);
        }
        return this.aux;
    }

    private void swap(int[] array, int i, int j){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    private void clone1(){
        this.aux = new int[this.nums.length];
        for (int i = 0; i < this.nums.length; i++) {
            aux[i] = this.nums[i];
        }
    }
}
