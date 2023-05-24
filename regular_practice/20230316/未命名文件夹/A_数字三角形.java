import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                in.nextToken();
                int x = (int) in.nval;
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + x;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) ans = Math.max(ans, f[n][i]);
        System.out.println(ans);
    }
}
