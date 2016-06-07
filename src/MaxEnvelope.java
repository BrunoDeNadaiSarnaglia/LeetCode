import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Bruno on 6/7/2016.
 */
public class MaxEnvelope {

    public static void main(String[] args){
        MaxEnvelope me = new MaxEnvelope();
        System.out.println(me.maxEnvelopes(new int[][]{new int[]{30,50}, new int[]{12,2}, new int[]{3,4}, new int[]{12,15}}));
    }

    private class Envelop{
        int height;
        int width;

        public Envelop(int height, int width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public String toString() {
            return "Envelop{" +
                    "height=" + height +
                    ", width=" + width +
                    '}';
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        Envelop[] envelops = GetEnvelopArray(envelopes);
        Arrays.sort(envelops, new Comparator<Envelop>() {
            @Override
            public int compare(Envelop o1, Envelop o2) {
                return o1.height - o2.height;
            }
        });
        return maxAscendentSeq(envelops);
    }

    private int maxAscendentSeq(Envelop[] sortedEnvelops){
        List<Envelop>[] lastEnvelopSeq = new List[sortedEnvelops.length];
        for (Envelop envelop : sortedEnvelops) {
            int idx = binSearch(lastEnvelopSeq, envelop);
            if(lastEnvelopSeq[idx] == null){
                lastEnvelopSeq[idx] = new ArrayList<Envelop>();
            }
            lastEnvelopSeq[idx].add(envelop);
        }
        return firstNonNull(lastEnvelopSeq);
    }

    private int firstNonNull(List<Envelop>[] envelops){
        int i = 0;
        while(i < envelops.length && envelops[i] != null){
            i++;
        }
        return i;
    }

    private int binSearch(List<Envelop>[] lastEnvelopSeq, Envelop envelop){
        int i = 0;
        int j = lastEnvelopSeq.length - 1;
        while(j >= i){
            int mid = i + (j - i)/2;
            if(lastEnvelopSeq[mid] == null || !CanBeOnTop(lastEnvelopSeq[mid], envelop)){
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    private boolean CanBeOnTop(List<Envelop> list, Envelop topEnvelop){
        for (Envelop envelop: list) {
            if(Greater(envelop, topEnvelop))    return true;
        }
        return false;
    }

    private boolean Greater(Envelop envelop1, Envelop envelop2){
        return envelop2.height > envelop1.height && envelop2.width > envelop1.width;
    }

    private Envelop[] GetEnvelopArray(int[][] envelopes){
        Envelop[] envelops = new Envelop[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            envelops[i] = new Envelop(envelopes[i][0], envelopes[i][1]);
        }
        return envelops;
    }
}
