/**
 * Created by Bruno on 10/10/2016.
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()) return addStrings(num2, num1);
        StringBuilder sb = new StringBuilder();
        int reminder = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (j >= 0){
            int a = num1.charAt(i--) - '0';
            int b = num2.charAt(j--) - '0';
            sb.append((a + b + reminder) % 10);
            reminder = (a + b + reminder) / 10;
        }
        while (i >= 0){
            int a = num1.charAt(i--) - '0';
            sb.append((a + reminder) % 10);
            reminder = (a + reminder) / 10;
        }
        if(reminder != 0) sb.append(reminder);
        return trim(sb.reverse().toString());
    }

    private String trim(String num){
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0'){
            i++;
        }
        return (i == num.length()? "0" : num.substring(i));
    }

}
