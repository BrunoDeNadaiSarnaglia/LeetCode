import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Bruno on 7/17/2016.
 */
public class ValidParentheses {

    HashSet<Character> setOpen = new HashSet<Character>(){{ add('('); add('['); add('{');}};
    HashMap<Character, Character> mapClose = new HashMap<Character, Character>(){{ put('(', ')'); put('[', ']'); put('{', '}');}};

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for (Character ch: s.toCharArray()) {
            if(setOpen.contains(ch)) stk.add(ch);
            else if(mapClose.containsKey(ch)){
                if(stk.isEmpty() || stk.peek() != mapClose.get(ch)) return false;
                stk.pop();
            }
        }
        return stk.isEmpty();
    }
}
