import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Sarnaglia on 1/15/17.
 */
public class ZumaGame {

    public static void main(String[] args){
        ZumaGame zg = new ZumaGame();
        System.out.println(zg.findMinStep("G", "GGGGG"));
        System.out.println(zg.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(zg.findMinStep("WRRBBW", "RB"));
        System.out.println(zg.findMinStep("BGGRRYY", "BBYRG"));
        System.out.println(zg.findMinStep("GWGWGGWRRWRYGYYRGYYB", "WYBYB"));
        System.out.println(zg.findMinStep("BRBGGBB", "GWRYR"));

    }

    public int findMinStep(String board, String hand) {
        int min = findMinStep(board, hand, new HashMap<String, Integer>(), Integer.MAX_VALUE);
        return (min == Integer.MAX_VALUE ? -1 : min);
    }

    private class Pair {
        private String board;
        private String hand;

        public Pair(String board, String hand) {
            this.board = board;
            this.hand = hand;
        }
    }

    public int findMinStep(String board, String hand, HashMap<String, Integer> map, int min) {
        if(board.length() == 0) return 0;
        if(min <= 1)  return Integer.MAX_VALUE;
        if(map.containsKey(board + "|" + hand)) return map.get(board + "|" + hand);
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < board.length() + 1; i++) {
            for (int j = 0; j < hand.length(); j++) {
                if((i - 1 >= 0 && hand.charAt(j) == board.charAt(i-1)) || (i < board.length() && hand.charAt(j) == board.charAt(i))){
                    String newBoard = board.substring(0,i) + hand.charAt(j) + board.substring(i);
                    String newHand = hand.substring(0, j) + hand.substring(j + 1);
                    newBoard = filter(newBoard);
                    list.add(new Pair(newBoard, newHand));
                }
            }
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.board.length() - o2.board.length();
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int minStep = findMinStep(list.get(i).board, list.get(i).hand, map, min - 1);
            min = (minStep == Integer.MAX_VALUE ? min : Math.min(min, 1 + minStep));
        }
        map.put(board + "|" + hand, min);
//        for (Pair p : list) {
//            int minStep = findMinStep(p.board, p.hand, min - 1);
//            min = (minStep == Integer.MAX_VALUE ? min : Math.min(min, 1 + minStep));
//        }
        return min;
    }


    private String filter(String board) {
        char[] balls = new char[] {'R', 'Y', 'B', 'G', 'W'};
        int len;
        do {
            len = board.length();
            for (int i = 0; i < balls.length; i++) {
                board = filter(board, balls[i]);
            }
        } while (len != board.length());
        return board;
    }

    private String filter(String board, char ch){
        int i = 0;
        for (int k = 0; k < board.length() + 1; k++) {
            if(k == board.length() || board.charAt(k) != ch) {
                if(k - i >= 3){
                    return board.substring(0, i) + filter(board.substring(k), ch);
                } else {
                    i = k + 1;
                }
            }
        }
        return board;
    }

}
