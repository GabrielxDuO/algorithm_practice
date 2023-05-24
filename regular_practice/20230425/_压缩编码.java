import java.util.*;
import java.io.*;

public class _压缩编码 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); s[i] = s[i - 1] + (int) in.nval;
        }
        int[][] f = new int[n + 1][n + 1];
        for (int len = 2; len <= n; ++len) {
            for (int i = 1; i + len - 1 <= n; ++i) {
                int j = i + len - 1;
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + s[j] - s[i - 1]);
                }
            }
        }
        System.out.println(f[1][n]);
    }
}
