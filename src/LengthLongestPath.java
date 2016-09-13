import java.util.LinkedList;

/**
 * Created by Bruno on 9/12/2016.
 */
public class LengthLongestPath {

    public int lengthLongestPath(String input) {
        String[] strings = input.split("\n");
        int max = 0;
        LinkedList<String> l = new LinkedList<String>();
        for (String string : strings) {
            int asd = 0;
            while (string.startsWith("\t")){
                asd++;
                string = string.substring(1);
            }
            while (l.size() > asd){
                l.removeLast();
            }
            l.add(string);
            int sum = 0;
            if(!string.contains(".")) continue;
            for (String string1 : l) {
                sum += string1.length() + 1;
            }
            max = Math.max(max, sum - 1);
        }
        return max;
    }

}
