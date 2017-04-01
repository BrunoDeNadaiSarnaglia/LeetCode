/**
 * Created by Sarnaglia on 4/1/17.
 */
public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String a, String b) {
        int realA = Integer.parseInt(a.split("\\+")[0]);
        int realB = Integer.parseInt(b.split("\\+")[0]);
        int complexA = Integer.parseInt(a.split("\\+")[1].split("i")[0]);
        int complexB = Integer.parseInt(b.split("\\+")[1].split("i")[0]);
        return (realA * realB - complexA * complexB) + "+" + (realA * complexB + realB * complexA) + "i";
    }
}
