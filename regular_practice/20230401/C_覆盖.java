import java.util.*;
import java.io.*;

public class C_覆盖 {
    static final int N = 10, M = 1 << N;
    static int n = 8;
    static long[][] dp = new long[N][M];
    static List<Integer>[] states = (ArrayList<Integer>[]) new ArrayList[M];
    static boolean[] isValids = new boolean[M];
    
    public static void main(String[] args) throws IOException {
        int o = 1 << n;
        for (int i = 0; i < o; ++i) {
            int cnt = 0;
            boolean isValid = true;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    if ((cnt & 1) != 0) {
                        isValid = false;
                        break;
                    }
                    cnt = 0;
                } else ++cnt;
            }
            if ((cnt & 1) != 0) isValid = false;
            isValids[i] = isValid;
        }
        for (int i = 0; i < o; ++i) {
            if (states[i] == null) states[i] = new ArrayList<>();
            else states[i].clear();
            for (int j = 0; j < o; ++j) {
                if ((i & j) == 0 && isValids[i | j]) {
                    states[i].add(j);
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < o; ++j) dp[i][j] = 0;
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < o; ++j) {
                for (int s : states[j]) dp[i][j] += dp[i - 1][s];
            }
        }
        System.out.println(dp[n][0]);
    }
}
