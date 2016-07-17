import java.util.ArrayList;

/**
 * Created by Bruno on 7/17/2016.
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] array = shrink(s).toCharArray();
        reverse(array, 0, array.length - 1);
        for (int i = 0, ini = 0; i <= array.length; i++) {
            if(array[i] == ' '){
                reverse(array, ini, i-1);
                ini = i + 1;
            }
        }
        return new String(array);
    }

    private String shrink(String s){
        StringBuilder sb = new StringBuilder();
        boolean previousSpace = true;
        for (int k = 0; k < s.length(); k++) {
            if(s.charAt(k) != ' '){
                sb.append(s.charAt(k));
                previousSpace = false;
            } else if(!previousSpace){
                sb.append(s.charAt(k));
                previousSpace = true;
            }
        }
        return sb.toString().trim();
    }

    private void reverse(char[] array, int i, int j){
        while(i < j){
            swap(array, i++, j--);
        }
    }

    private void swap(char[] array, int i, int j){
        char aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

}
