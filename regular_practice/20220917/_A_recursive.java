import java.io.*;

public class _A_recursive {
    static final int MOD = (int) 1e9 + 7;
    static final int[] opp = {-1, 4, 5, 6, 1, 2, 3};
    static boolean[][] conflict = new boolean[7][7];
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        while (m-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            conflict[a][b] = true;
            conflict[b][a] = true;
        }
        long ans = 0L;
        for (int i = 1; i <= 6; ++i) {
            ans = (ans + dfs(i, n)) % MOD;
        }
        System.out.println(ans);
    }

    static long dfs(int top, int dice) {
        if (dice == 1) return 4;
        long poss = 0L;
        int bottom = opp[top];
        for (int i = 1; i <= 6; ++i) {
            if (conflict[bottom][i]) continue;
            poss = (poss + 4 * dfs(i, dice - 1)) % MOD;
        }
        return poss;
    }
}
