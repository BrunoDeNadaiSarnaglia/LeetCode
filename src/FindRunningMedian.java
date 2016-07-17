import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Bruno on 7/17/2016.
 */
public class FindRunningMedian {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(100000, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int nextVal = scanner.nextInt();
        System.out.println(nextVal);
        maxHeap.add(nextVal);
        while (scanner.hasNext()){
            nextVal = scanner.nextInt();
            if(maxHeap.size() == minHeap.size()){
                if(nextVal <= minHeap.peek()){
                    maxHeap.add(nextVal);
                } else {
                    minHeap.add(nextVal);
                    maxHeap.add(minHeap.poll());
                }
                System.out.println(maxHeap.peek());
            } else {
                if(nextVal >= maxHeap.peek()){
                    minHeap.add(nextVal);
                } else {
                    maxHeap.add(nextVal);
                    minHeap.add(maxHeap.poll());
                }
                System.out.println(((double) maxHeap.peek() + (double)minHeap.peek()) / 2.0);
            }
        }
    }
}
