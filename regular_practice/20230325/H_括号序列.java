import java.io.*;
import java.util.*;

public class H_括号序列 {
    static final int MOD = (int) 1e9 + 7;
    
    static long dp(char[] s) {
        int n = s.length - 1;
        long[][] f = new long[n + 10][n + 10];
        f[0][0] = 1L;
        for (int i = 1; i <= n; ++i) {
            if (s[i] == '(') {
                for (int j = 1; j <= n; ++j) f[i][j] = f[i - 1][j - 1];
            } else {
                f[i][0] = (f[i - 1][0] + f[i - 1][1]) % MOD;
                for (int j = 1; j <= n; ++j) f[i][j] = (f[i - 1][j + 1] + f[i][j - 1]) % MOD;
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (f[n][i] != 0) return f[n][i];
        }
        return -1L;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        long l = dp(('\0' + s).toCharArray());
        char[] chs = new StringBuilder(s).reverse().insert(0, '\0').toString().toCharArray();
        for (int i = 0; i < chs.length; ++i) chs[i] = chs[i] == '(' ? ')' : '(';
        long r = dp(chs);
        System.out.println((l * r) % MOD);
    }
}