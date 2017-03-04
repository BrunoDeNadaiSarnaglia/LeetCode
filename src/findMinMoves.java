/**
 * Created by Sarnaglia on 2/22/17.
 */
public class findMinMoves {

    public static void main(String[] args){
        findMinMoves f = new findMinMoves();
        System.out.println(f.findMinMoves(new int[]{ 1, 0, 5 }));
    }

    public int findMinMoves(int[] machines) {
        if(machines == null)    return -1;
        if(machines.length == 0) return 0;
        int sum = sum(machines);
        if(sum % machines.length != 0)  return -1;
        int avr = sum / machines.length;
//        for (int i = 0; i < machines.length; i++) {
//            machines[i] -= avr;
//        }
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < machines.length && j < machines.length){
            if(machines[i] >= avr)   i++;
            else if(machines[j] <= avr) j++;
            else {
                max += Math.abs(j - i);
                machines[i]++;
                machines[j]--;
            }
        }
        return max;
    }

    private int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

}
