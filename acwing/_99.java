import java.util.*;
import java.io.*;

public class _99 {
    static final int N = 5001;
    static int n, r;
    static long[][] s = new long[N + 1][N + 1];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); r = (int) in.nval;
        while (n-- > 0) {
            in.nextToken(); int x = (int) in.nval;
            in.nextToken(); int y = (int) in.nval;
            in.nextToken(); s[x + 1][y + 1] += (int) in.nval;
        }
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }
        if (r >= N) {
            System.out.println(s[N][N]);
            return;
        }
        long ans = 0L;
        for (int x = r; x <= N; ++x) {
            for (int y = r; y <= N; ++y) {
                long sum = s[x][y] - s[x][y - r] - s[x - r][y] + s[x - r][y - r];
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}
