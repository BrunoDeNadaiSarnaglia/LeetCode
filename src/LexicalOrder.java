import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruno on 9/12/2016.
 */

public class LexicalOrder {

    public static void main(String[] args){
        LexicalOrder l = new LexicalOrder();
        System.out.print(l.lexicalOrder(234));
    }

    public List<Integer> lexicalOrder(int n) {
        if(n <= 0)  return  null;
        List<Integer> list = new ArrayList<Integer>();
        int val = 1;
        list.add(1);
        while(true){
            if(10 * val <= n){
                val *= 10;
                list.add(val);
            } else if(val % 10 != 9 && val + 1 <= n){
                val++;
                list.add(val);
            } else {
                val /= 10;
                val++;
                while(val % 10 == 0){
                    val /= 10;
                }
                if(val == 1)    break;
                list.add(val);
            }
        }
        return list;
    }
}
