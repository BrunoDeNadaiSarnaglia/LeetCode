/**
 * Created by Bruno on 5/4/2016.
 */
public class reverseVowels {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            if(!isVowel(array[i])){
                i++;
            } else if(!isVowel(array[j])){
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        return new String(array);
    }

    private boolean isVowel(char character){
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u' ||
                character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U';
    }


    private void swap(char[] array, int i, int j){
        char aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
