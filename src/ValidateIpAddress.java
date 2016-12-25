/**
 * Created by Bruno on 12/25/2016.
 */
public class ValidateIpAddress {

    public static void main(String[] args){
        ValidateIpAddress  v = new ValidateIpAddress();
        System.out.print(v.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }

    public String validIPAddress(String IP) {
        if (isIPv4(IP)){
            return "IPv4";
        }
        if (isIPv6(IP)){
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv6(String IP){
        if(IP.contains("-"))    return false;
        String[] split = IP.split(":", -1);
        if(split.length != 8)   return false;
        for (String str : split) {
            if(str.length() > 4)    return false;
            try{
                Integer val = Integer.parseInt(str, 16);
            } catch (Exception e){
                return false;
            }
        }
        return true;
    }

    private boolean isIPv4(String IP){
        if(IP.contains("-"))    return false;
        String[] split = IP.split("\\.", -1);
        if(split.length != 4)   return false;
        for (String str : split) {
            Integer val;
            try{
                val = Integer.parseInt(str);
            } catch (Exception e){
                return false;
            }
            if(val.toString().length() != str.length()) return false;
            if(val >= 256)  return false;
        }
        return true;
    }

}
