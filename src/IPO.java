import java.util.PriorityQueue;

/**
 * Created by Sarnaglia on 2/7/17.
 */
public class IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[]{Capital[i], Profits[i]});
        }
        int i = 0;
        while(i < k){
            if(!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            } else if(!pqPro.isEmpty()) {
                W += pqPro.poll()[1];
                i++;
            } else {
                break;
            }
        }
        return W;
    }

}
