import java.util.*;
import java.io.*;

public class _阮小二买彩票 {
    static int[] nums = new int[10];
    static int n = 0;
    static int[] chosen;
    static boolean[] used;
    static Set<String> st = new HashSet<>();

    static void dfs(int u) {
        if (u == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) sb.append(chosen[i]);
            String s = sb.toString();
            if (!st.contains(s)) {
                System.out.println(s);
                st.add(s);
            }
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                used[i] = true;
                chosen[u] = nums[i];
                dfs(u + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        while (num > 0) {
            nums[n++] = num % 10;
            num /= 10;
        }
        Arrays.sort(nums, 0, n);
        chosen = new int[n];
        used = new boolean[n];
        dfs(0);
    }
}
