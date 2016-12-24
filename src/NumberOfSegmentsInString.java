/**
 * Created by Bruno on 12/24/2016.
 */
public class NumberOfSegmentsInString {


    public int countSegments(String s) {
        int count = 0;
        boolean hasSpaceBefore = true;
        for (Character ch : s.toCharArray()) {
            if(ch == ' ') {
                hasSpaceBefore = true;
            }
            else if(hasSpaceBefore){
                count++;
                hasSpaceBefore = false;
            }
        }
        return count;
    }

}
