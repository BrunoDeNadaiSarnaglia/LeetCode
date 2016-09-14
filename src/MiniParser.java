import java.util.List;

/**
 * Created by Bruno on 9/14/2016.
 */
public class MiniParser {


      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public class NestedInteger {

          public NestedInteger(){}

          // Constructor initializes a single integer.
          public NestedInteger(int value){}

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger(){return false;}

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger(){return null;}

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value){}

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni){}

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList(){return null;}
      }

    private class IntegerMutable {
        private int i = 0;

        public IntegerMutable(int i) {
            this.i = i;
        }

        public void inc(){
            this.i++;
        }

        public int get(){
            return this.i;
        }
    }

    public NestedInteger deserialize(String s) {
        return deserialize(s, new IntegerMutable(0));
    }

    private NestedInteger deserialize(String s, IntegerMutable it){
        Integer val = null;
        boolean negative = false;
        if(s.charAt(it.get()) == '['){
            it.inc();
        }
        NestedInteger ni = new NestedInteger();
        for (; it.get() < s.length(); it.inc()) {
            Character ch = s.charAt(it.get());
            if(ch == '-'){
                negative = true;
            } else if(ch >= '0' && ch <= '9'){
                val = (val == null ? 0 : val);
                val *= 10;
                val += ch - '0';
            } else if(val != null){
                val = (negative ? -val : val);
                ni.add(new NestedInteger(val));
                val = null;
                negative = false;
            }
            if(ch == '[') {
                ni.add(deserialize(s, it));
            } else if(ch == ']') {
                return ni;
            }
        }
        if(val != null){
            val = (negative ? -val : val);
            return new NestedInteger(val);
        }
        return ni;
    }
}
