/**
 * Created by Bruno on 7/1/2016.
 */
public class SortIntegers {
    public void sortIntegers2(int[] A) {
        sortIntegers2(A, 0, A.length - 1);
    }


    private void sortIntegers2(int[] A, int i, int j) {
        if(i>= j) return;
        int mid = partition(A, i, j);
        sortIntegers2(A, i, mid - 1);
        sortIntegers2(A, mid + 1, j);
    }


    private int partition(int[] A, int i, int j){
        int pivot = i++;
        while(i <= j){
            if(A[i] <= A[pivot]){
                i++;
            } else if(A[j] > A[pivot]){
                j--;
            } else {
                swap(A, i++, j--);
            }
        }
        swap(A, pivot, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    public void sortIntegers(int[] A) {
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(A[i] > A[j]){
                    swap(A, i, j);
                }
            }
        }
    }

}
