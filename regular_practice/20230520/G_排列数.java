import java.util.*;
import java.io.*;

public class G_排列数 {
    static final int MOD = 123456;
    static int n, k;
    static int[] chosen;
    static boolean[] used;
    static int ans;

    static void dfs(int u) {
        if (u == n) {
            int cnt = 0;
            for (int i = 1; i < n - 1; ++i) {
                if (chosen[i] > chosen[i - 1] && chosen[i] > chosen[i + 1] ||
                    chosen[i] < chosen[i - 1] && chosen[i] < chosen[i + 1]) ++cnt;
            }
            if (cnt + 1 == k) ans = (ans + 1) % MOD;
            return;
        }
        for (int x = 1; x <= n; ++x) {
            if (used[x]) continue;
            chosen[u] = x;
            used[x] = true;
            dfs(u + 1);
            used[x] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt();
        chosen = new int[n];
        used = new boolean[n + 1];
        dfs(0);
        System.out.println(ans);
    }
}
