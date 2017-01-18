import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Sarnaglia on 1/18/17.
 */
public class PolishNotation {


    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, Operation> mapOp = new HashMap<>();

    private interface Operation {
        public Integer operation(Integer a, Integer b);
    }

    private class sum implements Operation{
        @Override
        public Integer operation(Integer a, Integer b) {
            return a + b;
        }
    }

    private class dif implements Operation{
        @Override
        public Integer operation(Integer a, Integer b) {
            return a - b;
        }
    }

    private class times implements Operation{
        @Override
        public Integer operation(Integer a, Integer b) {
            return a * b;
        }
    }
    private class div implements Operation{
        @Override
        public Integer operation(Integer a, Integer b) {
            return a / b;
        }
    }
    public PolishNotation() {
        this.map.put("(", 0);
        this.map.put("+", 1);
        this.map.put("-", 1);
        this.map.put("*", 2);
        this.map.put("/", 2);

        this.mapOp.put("+", new sum());
        this.mapOp.put("-", new dif());
        this.mapOp.put("*", new times());
        this.mapOp.put("/", new div());
    }

    public int evaluateExpression(String[] expression) {
        if(expression == null || expression.length == 0)    return 0;
        if(expression.length == 1)  return Integer.parseInt(expression[0]);
        ArrayList<String> polish = convertToRPN(expression);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < polish.size(); i++) {
            String s = polish.get(i);
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                stk.push(Integer.parseInt(s));
            } else {
                int a = stk.pop();
                int b = stk.pop();
                stk.push(this.mapOp.get(s).operation(b,a));
            }
        }
        return stk.isEmpty() ? 0 : stk.pop();
    }

    public ArrayList<String> convertToRPN(String[] expression) {
        ArrayList<String> posfix = new ArrayList<>();
        Stack<String> stkOp = new Stack<>();
        for (int i = 0; i < expression.length; i++) {
            String s = expression[i];
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")"))){
                posfix.add(s);
            } else if(s.equals("(")){
                stkOp.push(s);
            } else if(s.equals(")")){
                while (true){
                    String op = stkOp.pop();
                    if(op.equals("("))  break;
                    else posfix.add(op);
                }
            } else {
                while (!stkOp.isEmpty() && this.map.get(stkOp.peek()) <= this.map.get(s)){
                    posfix.add(stkOp.pop());
                }
                stkOp.push(s);
            }
        }
        while (!stkOp.isEmpty()){
            posfix.add(stkOp.pop());
        }
        return posfix;
    }

}
