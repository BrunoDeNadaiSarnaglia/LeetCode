/**
 * Created by Bruno on 5/24/2016.
 */
public class ReversePair {

    public static void main(String[] args){
        ReversePair rp = new ReversePair();
        System.out.println(rp.reversePairs(new int[]{2,4,1,3,5}));
    }

    public long reversePairs(int[] A){
        return reversePairs(A, 0, A.length - 1);
    }

    private long reversePairs(int[] A, int i, int j){
        if(i >= j) return 0;
        int mid = i + (j - i) / 2;
        long fh = reversePairs(A, i, mid);
        long sh = reversePairs(A, mid + 1, j);
        long m = mergePairs(A, i, j);
        return fh + sh + m;
    }

    private long mergePairs(int[] a, int i, int j) {
        int mid = i + (j - i) / 2;
        int[] aux = new int[j - i + 1];
        long count = 0;
        int itf = i;
        int its = mid + 1;
        int k = 0;
        while(itf <= mid || its <= j){
            if(itf == mid + 1){
                aux[k++] = a[its++];
            } else if(its <= j && a[itf] > a[its]){
                count++;
                aux[k++] = a[its++];
            } else {
                count += (itf == mid ? mid + 1 : its) - (mid + 1);
                aux[k++] = a[itf++];
            }
        }
        for (int l = 0, m = i; l < aux.length; l++, m++) {
            a[m] = aux[l];
        }
        return count;
    }

}
