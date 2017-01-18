/**
 * Created by Sarnaglia on 1/14/17.
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1, count = 0; i >= 0 ; i--) {
            if(S.charAt(i) == '-')  continue;
            if(sb.length() != 0 && (++count) % K == 0)  sb.append('-');
            if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z')    sb.append((char)(S.charAt(i) - 'a' + 'A'));
            else sb.append(S.charAt(i));
        }
        return sb.reverse().toString();
    }

}
