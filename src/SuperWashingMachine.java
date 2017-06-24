/**
 * Created by Sarnaglia on 5/3/17.
 */
public class SuperWashingMachine {

    public int findMinMoves(int[] machines) {
        int sum = sum(machines);
        if(sum % machines.length != 0)  return -1;
        int avr = sum / machines.length;
        int debt     = 0;
        int excedent = 0;
        for (int i = 0; i < machines.length; i++) {
            excedent += machines[i] - avr;
            debt += Math.abs(excedent);
        }
        return debt;
    }

    private int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

}
