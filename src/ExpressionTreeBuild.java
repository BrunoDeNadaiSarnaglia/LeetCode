import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Sarnaglia on 1/18/17.
 */
public class ExpressionTreeBuild {


    public class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;
        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }

    HashMap<String, Integer> map = new HashMap<>();

    public ExpressionTreeBuild() {
        this.map.put("(", 0);
        this.map.put("+", 1);
        this.map.put("-", 1);
        this.map.put("*", 2);
        this.map.put("/", 2);

    }

    public ExpressionTreeNode build(String[] expression) {
        if(expression == null || expression.length == 0)    return new ExpressionTreeNode("0");
        if(expression.length == 1)  return new ExpressionTreeNode("0");
        ArrayList<String> polish = convertToRPN(expression);
        Stack<ExpressionTreeNode> stk = new Stack<>();
        for (int i = 0; i < polish.size(); i++) {
            String s = polish.get(i);
            if(!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))){
                stk.push(new ExpressionTreeNode(s));
            } else {
                ExpressionTreeNode a = stk.pop();
                ExpressionTreeNode b = stk.pop();
                ExpressionTreeNode c = new ExpressionTreeNode(s);
                c.left = a;
                c.right = b;
                stk.push(c);
            }
        }
        return stk.isEmpty() ? new ExpressionTreeNode("0") : stk.pop();
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
                while (!stkOp.isEmpty() && this.map.get(stkOp.peek()) >= this.map.get(s)){
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
