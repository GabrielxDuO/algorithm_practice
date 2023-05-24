import java.util.*;
import java.io.*;

public class H_最优包含 {
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = ('\0' + in.nextLine()).toCharArray();
        char[] t = ('\0' + in.nextLine()).toCharArray();
        int n = s.length - 1, m = t.length - 1;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) f[i][0] = 0;
        for (int j = 1; j <= m; ++j) f[0][j] = INF;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s[i] == t[j]) f[i][j] = f[i - 1][j - 1];
                else f[i][j] = Math.min(f[i - 1][j - 1] + 1, f[i - 1][j]);
            }
        }
        System.out.println(f[n][m]);
    }
}
