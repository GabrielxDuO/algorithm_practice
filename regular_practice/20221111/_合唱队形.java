import java.util.*;
import java.io.*;

public class _合唱队形 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }
        int[] dp1 = new int[n], dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = n - 1; j > i; --j) {
                if (nums[j] < nums[i]) dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dp1[i] + dp2[i] - 1);
        }
        System.out.println(n - ans);
    }
}
