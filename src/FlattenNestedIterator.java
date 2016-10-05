import java.util.*;

// This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation

import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    private class IntegerIterator implements Iterator<Integer>{

        private int num;
        private boolean hasNext = true;

        public IntegerIterator(Integer num) {
            this.num = num;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public Integer next() {
            if(hasNext()){
                hasNext = false;
                return num;
            }
            return -1;
        }

        @Override
        public void remove() {

        }
    }

    private class NestedIntegerIterator implements Iterator<Integer> {

        Iterator<Integer> it;

        public NestedIntegerIterator(NestedInteger nestedInteger) {
            if(nestedInteger.isInteger()){
                it = new IntegerIterator(nestedInteger.getInteger());
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

        @Override
        public void remove() {

        }
    }

    LinkedList<Iterator<Integer>> listIt = new LinkedList<Iterator<Integer>>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger: nestedList) {
            Iterator<Integer> it = new NestedIntegerIterator(nestedInteger);
            if(it.hasNext())    listIt.add(it);
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        Integer val = listIt.getFirst().next();
        if(!listIt.getFirst().hasNext())    listIt.removeFirst();
        return val;
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        return !listIt.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */