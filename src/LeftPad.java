/**
 * Created by Bruno on 6/30/2016.
 */
public class LeftPad {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuilder strBui = new StringBuilder(originalStr).reverse();
        while(strBui.length() < size){
            strBui.append(padChar);
        }
        return strBui.reverse().toString();
    }
}
