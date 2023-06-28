import java.util.*;
import java.io.*;

public class _035 {
    static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static final int N = 35;
    static int n, idx;
    static int[] tr = new int[N];

    public static void dfs(int u) throws IOException {
        if (u > n) return;
        dfs(u << 1);
        dfs(u << 1 | 1);
        in.nextToken(); tr[u] = (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in.nextToken(); n = (int) in.nval;
        dfs(1);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            ans.append(tr[i]);
            if (i == n) ans.append("\n");
            else ans.append(" ");
        }
        System.out.print(ans);
    }
}
