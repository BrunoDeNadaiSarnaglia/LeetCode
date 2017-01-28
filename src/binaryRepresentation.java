import java.util.HashSet;

/**
 * Created by Sarnaglia on 1/27/17.
 */
public class binaryRepresentation {

    public String binaryRepresentation(String n) {
        String[] split = n.split("\\.");
        int fh = Integer.parseInt(split[0]);
        int sh = Integer.parseInt(split[1]);
        try{
            return binaryRepresentationInteger(fh) + (sh != 0 ? "." + binaryRepresentationReal(split[1]) : "");
        } catch (Exception e){
            return "ERROR";
        }
    }

    private String binaryRepresentationInteger(int num){
        if(num == 0)    return "0";
        return binaryRepresentationIntegerNonZero(num);
    }

    private String binaryRepresentationIntegerNonZero(int num){
        if(num == 0)    return "";
        return binaryRepresentationIntegerNonZero(num/2) + (num % 2 == 1 ? "1" : "0");
    }

    private String binaryRepresentationReal(String num) throws Exception {
        HashSet<Long> cache = new HashSet<>();
        long decimal = 1;
        long val = Long.parseLong(num);
        while (val >= decimal){
            decimal *= 10;
        }
        for (int i = 0; i < num.length() && num.charAt(i) == '0'; i++, decimal *= 10);
        return binaryRepresentationReal(val, decimal, cache);
    }

    private String binaryRepresentationReal(long num, long decimal, HashSet<Long> cache) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (num == 0 || sb.length() > 32) return sb.toString();
            cache.add(num);
            num *= 2;
            if (cache.contains(num % decimal)) throw new Exception();
            sb.append((num >= decimal ? "1" : "0"));
            num %= decimal;
        }
    }


}
