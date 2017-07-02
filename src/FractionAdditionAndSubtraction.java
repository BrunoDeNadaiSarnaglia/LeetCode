import java.util.Arrays;

/**
 * Created by Sarnaglia on 7/2/17.
 */
public class FractionAdditionAndSubtraction {

    public static void main(String[] args) {
        FractionAdditionAndSubtraction f = new FractionAdditionAndSubtraction();
        System.out.println(f.fractionAddition("-1/2+1/6"));
    }

    public String fractionAddition(String expression) {
        String[] fractions = (expression.charAt(0) != '-' ? expression.split("[-+]") : expression.substring(1).split("[-+]"));
        String signals = (expression.charAt(0) == '-' ? "" : "+") + expression.replaceAll("[^+-]+", "");
        int lcm = 1;
        for (int i = 0; i < fractions.length; i++) {
            int den = Integer.parseInt(fractions[i].split("\\/")[1]);
            lcm = lcm(lcm, den);
        }
        int sum = 0;
        for (int i = 0; i < fractions.length; i++) {
            int num = Integer.parseInt(fractions[i].split("\\/")[0]);
            int den = Integer.parseInt(fractions[i].split("\\/")[1]);
            char sig = signals.charAt(i);
            sum += (sig == '-' ? -1 : 1) * num * lcm / den;
        }
        String sigRes = sum < 0 ? "-" : "";
        sum = Math.abs(sum);
        int gcd = gcd(sum, lcm);
        return sigRes + (sum / gcd) + "/" + (lcm / gcd);
    }


    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if(a > b)   return gcd(b, a);
        if(a == 0)  return b;
        return gcd(b % a, a);
    }
}
