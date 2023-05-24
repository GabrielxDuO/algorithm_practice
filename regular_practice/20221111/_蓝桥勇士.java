import java.util.*;
import java.io.*;

public class _蓝桥勇士 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[j] + 1, dp[i]);
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(ans);
    }
}
