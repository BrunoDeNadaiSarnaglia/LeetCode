import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Bruno on 9/13/2016.
 */
public class PerfectRectangle {

    public static void main(String[] args){
        PerfectRectangle pr = new PerfectRectangle();
        pr.isRectangleCover(
                new int[][]{
                        new int[]{1, 1, 3, 3},
                        new int[]{3, 1, 4, 2},
                        new int[]{1, 3, 2, 4},
                        new int[]{2, 2, 4, 4}
                }
        );
    }

    private class VerticalLine {

        private int low;
        private int high;

        public VerticalLine(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }


    private class VerticalSeries{

        private int x;
        private VerticalLine vl;

        public VerticalSeries(int x, VerticalLine vl) {
            this.x = x;
            this.vl = vl;
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        VerticalSeries[] array = new VerticalSeries[rectangles.length];
        VerticalSeries[] array2 = new VerticalSeries[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            array[i] = new VerticalSeries(rectangles[i][0], new VerticalLine(rectangles[i][1], rectangles[i][3]));
            array2[i] = new VerticalSeries(rectangles[i][2], new VerticalLine(rectangles[i][1], rectangles[i][3]));
        }
        TreeSet<VerticalLine> tree = new TreeSet<VerticalLine>(new Comparator<VerticalLine>() {
            @Override
            public int compare(VerticalLine o1, VerticalLine o2) {
                if(o1.low >= o2.high) return -1;
                else if (o1.high <= o2.low) return 1;
                return 0;
            }
        });
        int i = 0;
        int j = 0;
        Arrays.sort(array, new Comparator<VerticalSeries>() {
            @Override
            public int compare(VerticalSeries o1, VerticalSeries o2) {
                return o1.x - o2.x;
            }
        });

        Arrays.sort(array2, new Comparator<VerticalSeries>() {
            @Override
            public int compare(VerticalSeries o1, VerticalSeries o2) {
                return o1.x - o2.x;
            }
        });
        int sum = -1;
        while (i < array.length && j < array2.length){
            int x = Math.min(array[i].x, array2[j].x);
            int a = 0;
            int b = 0;
            while(j < array2.length && array2[j].x == x){
                a += array2[j].vl.high - array2[j].vl.low;
                tree.remove(array2[j++].vl);
            }
            while(i < array.length && array[i].x == x){
                if(tree.contains(array[i].vl))  return false;
                b += array[i].vl.high - array[i].vl.low;
                tree.add(array[i++].vl);
            }
            if(sum == -1)   sum = sum(tree);
            if(a != b)  return false;
        }
        return true;
    }


    private int sum(TreeSet<VerticalLine> tree){
        Iterator<VerticalLine> it = tree.iterator();
        int sum = 0;
        while (it.hasNext()){
            VerticalLine vl = it.next();
            sum += vl.high - vl.low;
        }
        return sum;
    }
}
