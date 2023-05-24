import java.util.*;
import java.io.*;

public class _数字三角形 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                in.nextToken();
                f[i][j] = Math.max(f[i - 1][j - 1], f[i - 1][j]) + (int) in.nval;
            }
        }
        System.out.println((n & 1) == 1 ? f[n][n / 2 + 1] : Math.max(f[n][n / 2], f[n][n / 2 + 1]));
    }
}
