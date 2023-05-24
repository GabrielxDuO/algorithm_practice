import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 998244353;
    static int n, w, l, r, x, y, z;
    static int[] cnts;
    static long ans;

    static void dfs(int u) {
        if (u > y) {
            if (cnts[x] * z == cnts[y]) ans = (ans + 1) % MOD;
            return;
        }
        for (int o = l; o <= r; ++o) {
            cnts[u] = cnts[u - 1] + o;
            dfs(u + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); w = in.nextInt();
        l = in.nextInt(); r = in.nextInt();
        x = in.nextInt(); y = in.nextInt(); z = in.nextInt();
        cnts = new int[y + 1];
        cnts[1] = w;
        dfs(2);
        System.out.println(ans);
    }
}
