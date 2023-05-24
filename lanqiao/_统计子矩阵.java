import java.util.*;
import java.io.*;

public class _统计子矩阵 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        int[][] s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                in.nextToken(); s[i][j] = s[i - 1][j] + (int) in.nval;
            }
        }
        long ans = 0L;
        for (int x1 = 1; x1 <= n; ++x1) {
            for (int x2 = x1; x2 <= n; ++x2) {
                for (int l = 1, r = 1, sum = 0; r <= m; ++r) {
                    sum += s[x2][r] - s[x1 - 1][r];
                    while (sum > k) {
                        sum -= s[x2][l] - s[x1 - 1][l];
                        ++l;
                    }
                    ans += r - l + 1;
                }
            }
        }
        System.out.println(ans);
    }
}
