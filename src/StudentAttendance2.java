import java.util.HashMap;

/**
 * Created by Sarnaglia on 4/30/17.
 */
public class StudentAttendance2 {

    public static void main(String[] args) {
        StudentAttendance2 s = new StudentAttendance2();
        System.out.println(s.checkRecord(100));
    }

    public int checkRecord(int n) {
        final int MOD = 1000000007;
        long[][][] cache = new long[n + 1][2][3];
        cache[1] = new long[][] {new long[]{1,1,1}, new long[]{1,1,1}};
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                cache[i][j][0] += dp(i - 1, j - 1, 0, cache);
                cache[i][j][0] += dp(i - 1, j - 1, 1, cache);
                cache[i][j][0] += dp(i - 1, j - 1, 2, cache);
                cache[i][j][0] += dp(i - 1, j, 0, cache);
                cache[i][j][0] += dp(i - 1, j, 1, cache);
                cache[i][j][0] += dp(i - 1, j, 2, cache);
                for (int k = 1; k <= 2; k++) {
                    cache[i][j][k] = dp(i - 1, j, k - 1, cache);
                }
            }
        }
        return (int)((dp(n, 0, 0, cache)
                + dp(n, 0, 1, cache)
                + dp(n, 0, 2, cache)
                + dp(n, 1, 0, cache)
                + dp(n, 1, 1, cache)
                + dp(n, 1, 2, cache)) % MOD);
    }

    private long dp(int i, int j, int k, long[][][] cache) {
        final int MOD = 1000000007;
        if(j < 0 || k < 0)  return 0;
        if(i < j + k)   return 0;
        if(i == 1)  return 1;
        return cache[i][j][k] % MOD;
    }

}
