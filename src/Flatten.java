import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 10/5/2016.
 */
public class Flatten {

 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
public interface NestedInteger {
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
    public class Solution {

        // @param nestedList a list of NestedInteger
        // @return a list of integer
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nestedList.size(); i++){
                list.addAll(flatten(nestedList.get(i)));
            }
            return list;
        }

        public List<Integer> flatten(NestedInteger nestedInteger){
            if(nestedInteger.isInteger()){
                List<Integer> l = new ArrayList<Integer>();
                l.add(nestedInteger.getInteger());
                return l;
            } else {
                return flatten(nestedInteger.getList());
            }
        }
    }
}
