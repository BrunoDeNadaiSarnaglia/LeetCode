import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class NestedIterator implements Iterator<Integer> {

    private class SingleIntegerInterator implements Iterator<Integer> {
        int value;
        boolean hasNext = true;
        public SingleIntegerInterator(int value) {
            this.value = value;
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override
        public Integer next() {
            this.hasNext = false;
            return value;
        }
    }

    private class NestedElementIterator implements Iterator<Integer>{

        Iterator<Integer> it;

        public NestedElementIterator(NestedInteger nestedInteger) {
            if(nestedInteger.isInteger()){
                it = new SingleIntegerInterator(nestedInteger.getInteger());
            } else {
                it = new NestedIterator(nestedInteger.getList());
            }
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Integer next() {
            return it.next();
        }
    }

    List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();
    int i = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger nestedInteger : nestedList){
            Iterator<Integer> it = new NestedElementIterator(nestedInteger);
            if(!it.hasNext()){
                continue;
            }
            list.add(it);
        }
    }

    @Override
    public Integer next() {
        Iterator<Integer> it = list.get(i);
        int next = it.next();
        if(!it.hasNext()){
            i++;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }
}
