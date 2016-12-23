import java.util.*;

/**
 * Created by Bruno on 12/23/2016.
 */
public class MinArrows {

    public static void main(String[] args){
        MinArrows m = new MinArrows();
//        System.out.println(m.findMinArrowShots(new int[][]{new int[]{10,16}, new int[]{2,8}, new int[]{1,6},new int[]{7,12}}));
        System.out.println(m.findMinArrowShots(new int[][]{
                new int[]{9, 12},
                new int[]{1, 10},
                new int[]{4, 11},
                new int[]{8, 12},
                new int[]{3, 9},
                new int[]{6, 9},
                new int[]{6, 7}}));
    }

    private class Baloon implements Comparable<Baloon>{

        private int start;
        private int end;

        public Baloon(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Baloon o) {
            return (this.start == o.start? this.end - o.end : this.start - o.start);
        }
    }

    public int findMinArrowShots(int[][] points) {
        Baloon[] array = new Baloon[points.length];
        for (int i = 0; i < points.length; i++) {
            array[i] =  new Baloon(points[i][0], points[i][1]);
        }
        Arrays.sort(array);
        int arrowCount = 0;
        int i = 0;
        while (i < array.length){
            int min = minBaloon(array, i);
//            System.out.println(min);
            for (int j = i; j < array.length; j++) {
                if(array[j].start <= min)  i = j + 1;
                else break;
            }
            arrowCount++;
        }
        return arrowCount;
    }


    private int minBaloon(Baloon[] array, int i){
        int min = array[i].end;
        for (int j = i + 1; j < array.length; j++) {
            if(min > array[j].end)    min = array[j].end;
            if(array[j].start > min)  break;
        }
        return min;
    }
}
