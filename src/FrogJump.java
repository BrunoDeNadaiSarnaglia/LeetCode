import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Bruno on 9/29/2016.
 */
public class FrogJump {


    public boolean canCross(int[] stones) {
        StoneFactory stoneFactory = new StoneFactory(stones);
        stoneFactory.getStone(0).addStep(0);
        for (Integer pos : stones) {
            IStone stone = stoneFactory.getStone(pos);
            Iterator<Integer> it  = stone.getSteps();
            while(it.hasNext()){
                int step = it.next();
                for (int i = -1; i <= 1; i++) {
                    if(step + i > 0){
                        IStone nextStone = stoneFactory.getStone(pos + step + i);
                        nextStone.addStep(step + i);
                    }
                }
            }
        }
        return stoneFactory.getStone(stones[stones.length - 1]).getSteps().hasNext();
    }

    private interface IStone {

        public Iterator<Integer> getSteps();

        public void addStep(int step);
    }

    private class StoneFactory {

        HashMap<Integer, IStone> map;
        IStone nilStone = new NilStone();

        public StoneFactory(int[] positions){
            map = new HashMap<Integer, IStone>();
            for(Integer pos : positions){
                map.put(pos, new Stone());
            }
        }

        public IStone getStone(int pos){
            if(map.containsKey(pos)){
                return map.get(pos);
            }
            return nilStone;
        }
    }

    private class Stone implements IStone {

        HashSet<Integer> set = new HashSet<Integer>();

        public Iterator<Integer> getSteps() {
            return set.iterator();
        }

        public void addStep(int step) {
            set.add(step);
        }

    }

    private class NilStone implements IStone {

        public Iterator<Integer> getSteps() { return Collections.<Integer>emptyList().iterator(); }

        public void addStep(int step) { }
    }

}
