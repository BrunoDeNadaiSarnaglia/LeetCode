import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

/**
 * Created by Bruno on 10/5/2016.
 */
public class MinNumber {


    public static void main(String[] args){
        MinNumber m = new MinNumber();
//        System.out.println(m.minNumber(new int[]{3,3,3,3,3,32,321}));
////        System.out.println(m.minNumber(new int[]{3,0,321}));
//        System.out.println(m.minNumber(new int[]{0,0}));
//        System.out.println(m.minNumber(new int[]{3577,9155,9352,7911,1622}));
        System.out.println(m.minNumber(new int[]{41,23,87,55,50,53,18,9,39,63,35,33,54,25,26,49,74,61,32,81,97,99,38,96,22,95,35,57,80,80,16,22,17,13,89,11,75,98,57,81,69,8,10,85,13,49,66,94,80,25,13,85,55,12,87,50,28,96,80,43,10,24,88,52,16,92,61,28,26,78,28,28,16,1,56,31,47,85,27,30,85,2,30,51,84,50,3,14,97,9,91,90,63,90,92,89,76,76,67,55}));
    }


    public String minNumber(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        for (Integer num : nums){
            l.add(num);
        }
        Collections.sort(l, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.equals(o2))    return 0;
                String o1String = o1.toString();
                String o2String = o2.toString();
                return compare(o1String, o2String, 0, 0);
            }

            private int compare(String o1, String o2, int o1Idx, int o2Idx){
                if(o2.length() - o2Idx> o1.length() - o1Idx) return -compare(o2, o1, o2Idx, o1Idx);
                if(o2.length() - o2Idx == 0)    return 0;
                while (o1Idx < o1.length() && o2Idx < o2.length()){
                    if(o1.charAt(o1Idx) != o2.charAt(o2Idx))    return o1.charAt(o1Idx) - o2.charAt(o2Idx);
                    o1Idx++;    o2Idx++;
                }
                return compare(o1, o2, o1Idx, 0);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer num: l) {
            sb.append(num);
        }
        return removeLeftZeros(sb.toString());
    }


    private String removeLeftZeros(String num){
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0')    i++;
        String numFiltered = num.substring(i);
        return (numFiltered.length() == 0? "0" : numFiltered);
    }
}
