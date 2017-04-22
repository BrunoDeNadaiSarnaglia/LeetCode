/**
 * Created by Sarnaglia on 4/10/17.
 */
public class ReverseWordsInString3 {

    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        char[] array = s.toCharArray();
        while (j + 1 < array.length){
            if(array[i] == ' '){
                i++;
            } else if(j < i) {
                j++;
            } else if(array[j + 1] == ' '){
                reverse(array, i, j);
                i = j + 1;
            } else {
                j++;
            }
        }
        reverse(array, i, j);
        return new String(array);
    }

    private void reverse(char[] array, int i, int j){
        while (i < j){
            swap(array, i++, j--);
        }
    }

    private void swap(char[] array, int i, int j){
        char aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

}
