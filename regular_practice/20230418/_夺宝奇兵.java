import java.util.*;
import java.io.*;

public class _夺宝奇兵 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                in.nextToken(); int x = (int) in.nval;
                f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1]) + x;
            }
        }
        int mx = 0;
        for (int i = 1; i <= n; ++i) mx = Math.max(mx, f[n][i]);
        System.out.println(mx);
    }
}
