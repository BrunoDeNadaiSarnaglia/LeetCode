import java.util.LinkedList;

/**
 * Created by Bruno on 7/17/2016.
 */
public class CoinChange {
//
//    public static void main(String[] args){
//        CoinChange cc = new CoinChange();
//        System.out.println(cc.coinChange(new int[]{1,2,5}, 11));
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        if(amount == 0) return 0;
//        int val = coinChange(coins, amount, 0, new LinkedList<Integer>());
//        return (val == 0 ? -1 : val);
//    }
//
//    private int coinChange(int[] coins, int amount, int i, LinkedList<Integer> l){
//        if(amount == 0) {
//            System.out.println(l);
//            return 1;
//        }
//        if(i >= coins.length || amount < 0)   return 0;
//        LinkedList<Integer> l2 = new LinkedList<Integer>(l);
//        l2.add(coins[i]);
//        return coinChange(coins, amount, i + 1, l) + coinChange(coins, amount - coins[i], i, l2);
//    }
}
