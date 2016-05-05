/**
 * Created by Bruno on 5/4/2016.
 */
public class reverseString {

    public String reverseString(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            swap(array, i++, j--);
        }
        return new String(array);
    }

    private void swap(char[] array, int i, int j){
        char aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

}
