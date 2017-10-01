import java.util.Stack;

/**
 * Created by Sarnaglia on 9/30/17.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stk = new Stack<>();
        for (String s:
             ops) {
            switch (s){
                case "D":
                    stk.push(2 * stk.peek());
                    break;
                case "C":
                    stk.pop();
                    break;
                case "+":
                    int a = stk.pop();
                    int b = stk.peek() + a;
                    stk.push(a);
                    stk.push(b);
                    break;
                default:
                    stk.push(Integer.parseInt(s));
                    break;
            }
        }
        int sum = 0;
        while (!stk.isEmpty()) {
            sum += stk.pop();
        }
        return sum;
    }
}
