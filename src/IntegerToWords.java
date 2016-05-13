import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Bruno on 5/13/2016.
 */
public class IntegerToWords {

    public static void main(String[] args){
        IntegerToWords as = new IntegerToWords();
        System.out.println(as.numberToWords(1234567891));
    }

    String[] list = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] list2 = new String[]{"Zero", "One", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] list3 = new String[]{"", "Thousand", "Million", "Billion", "Trillion"};
    String[] list4 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if(num == 0)    return "Zero";
        String value = "";
        int i = 0;
        for(;num != 0; num /= 1000, i++){
            String hundred = hundredsToWords(num%1000);
            if(hundred.length() == 0)   continue;
            value =  hundred + " " + list3[i] + " " + value;
        }
        return value.trim();
    }

    private String hundredsToWords(int num){
        String value = "";
        if(num/100 != 0)        value += list[num/100] + " Hundred ";
        if((num/10)%10 > 1)     value += list2[(num/10)%10] + " ";
        if((num/10)%10 == 1)    value += list4[num%10] + " ";
        if((num/10)%10 != 1 && num%10 != 0)    value += list[num%10];
        return value.trim();
    }
}
