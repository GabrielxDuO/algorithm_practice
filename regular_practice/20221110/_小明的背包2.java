import java.util.*;
import java.io.*;

public class _小明的背包2 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int V = (int) in.nval;
        int[] wts = new int[N], vals = new int[N];
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            wts[i] = (int) in.nval;
            in.nextToken();
            vals[i] = (int) in.nval;
        }
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; ++i) {
            int w = wts[i], v = vals[i];
            for (int j = w; j <= V; ++j) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[V]);
    }
}
