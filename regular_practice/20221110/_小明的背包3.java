import java.util.*;
import java.io.*;

public class _小明的背包3 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int V = (int) in.nval;
        int[] wts = new int[N], vals = new int[N], cnts = new int[N];
        for (int i = 0; i < N; ++i) {
            in.nextToken();
            wts[i] = (int) in.nval;
            in.nextToken();
            vals[i] = (int) in.nval;
            in.nextToken();
            cnts[i] = (int) in.nval;
        }
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; ++i) {
            int w = wts[i], v = vals[i];
            for (int j = V; j >= w; --j) {
                for (int k = 1; k <= cnts[i] && j >= k * w; ++k) {
                    dp[j] = Math.max(dp[j], dp[j - k * w] + v * k);
                }
            }
        }
        System.out.println(dp[V]);
    }
}
