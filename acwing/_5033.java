import java.util.*;
import java.io.*;

public class _5033 {
    static int n;
    static int[][] d;

    static void floyd() {
        int ans = 0;
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                in.nextToken(); d[i][j] = (int) in.nval;
            }
        }
        floyd();
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                ans = Math.max(ans, d[i][j]);
            }
        }
        System.out.println(ans);
    }
}
