import java.util.*;
import java.io.*;

public class _最大数字 {
    static int len;
    static int[] nums;
    static long ans = 0L;

    static void dfs(int idx, int inc, int dec) {
        if (idx == len) {
            long n = 0L;
            for (int x : nums) n = n * 10 + x;
            ans = Math.max(ans, n);
            return;
        }
        int up = 9 - nums[idx], down = nums[idx] + 1;
        int ori = nums[idx];
        if (inc >= up) {
            nums[idx] = 9;
            dfs(idx + 1, inc - up, dec);
            nums[idx] = ori;
        }
        if (dec >= down) {
            nums[idx] = 9;
            dfs(idx + 1, inc, dec - down);
            nums[idx] = ori;
        }
        if (inc < up && dec < down) {
            nums[idx] += inc;
            dfs(idx + 1, 0, dec);
            nums[idx] = ori;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] sn = String.valueOf(in.nextLong()).toCharArray();
        int a = in.nextInt(), b = in.nextInt();
        len = sn.length;
        nums = new int[len];
        for (int i = 0; i < len; ++i) nums[i] = sn[i] - '0';
        dfs(0, a, b);
        System.out.println(ans);
    }
}
