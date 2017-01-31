/**
 * Created by Sarnaglia on 1/30/17.
 */
public class teemoAttacking {


    public int findPoisonedDuration(int[] timeSeries, int duration) {
        teemoAttacking linearStrategy = new teemoAttacking();
        return linearStrategy.findPoisonedDuration(timeSeries, duration);
    }


    private interface teemoAttackingStrategy {
        int findPoisonedDuration(int[] timeSeries, int duration);
    }

    private class linearTeemoAttackingStrategy implements teemoAttackingStrategy{

        @Override
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            if(timeSeries == null || timeSeries.length == 0)    return 0;
            int sum = duration;
            for (int i = 0; i < timeSeries.length - 1; i++) {
                sum += (timeSeries[i] + duration > timeSeries[i + 1] ? timeSeries[i + 1] - timeSeries [i] : duration);
            }
            return sum;
        }
    }



}
