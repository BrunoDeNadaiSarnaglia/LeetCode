/**
 * Created by Sarnaglia on 4/22/17.
 */
public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {
        return !(hasMoreThanTwoAbsent(s) || hasTwoLate(s));
    }

    public boolean hasMoreThanTwoAbsent(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == 'A' ? 1 : 0);
            if(count > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasTwoLate(String s) {
        for (int i = 2; i < s.length(); i++) {
            if(s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return true;
            }
        }
        return false;
    }

}
