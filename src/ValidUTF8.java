/**
 * Created by Bruno on 9/11/2016.
 */
public class ValidUTF8 {

    public static void main(String[] args){
        ValidUTF8 v = new ValidUTF8();
        v.validUtf8(new int[]{ 197,130,1});
    }

    public boolean validUtf8(int[] data) {
        int val = 0;
        for (int i = 0; i < data.length; i++) {
            if(val != 0 && cod(data[i]) == 1){
                val--;
            } else if(val != 0 || cod(data[i]) == 1){
                return false;
            } else {
                val = cod(data[i]) - 1;
                val = (val < 0 ? 0 : val);
            }
        }
        return val == 0;
    }

    private int cod(int val){
        int a = 128;
        int cod = 0;
        while((val & a) != 0){
            a >>= 1;
            cod++;
        }
        return cod;
    }

}
