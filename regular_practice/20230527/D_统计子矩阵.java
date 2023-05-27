import java.util.*;
import java.io.*;

public class D_统计子矩阵 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        in.nextToken(); int k = (int) in.nval;
        int[][] g = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                in.nextToken(); g[i][j] = g[i - 1][j] + (int) in.nval;
            }
        }
        long cnt = 0L;
        for (int x1 = 1; x1 <= n; ++x1) {
            for (int x2 = x1; x2 <= n; ++x2) {
                int sum = 0;
                for (int l = 1, r = 1; r <= m; ++r) {
                    sum += g[x2][r] - g[x1 - 1][r];
                    while (sum > k) {
                        sum -= g[x2][l] - g[x1 - 1][l];
                        ++l;
                    }
                    cnt += r - l + 1;
                }
            }
        }
        System.out.println(cnt);
    }
}
