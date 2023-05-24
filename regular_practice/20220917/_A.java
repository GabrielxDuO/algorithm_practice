import java.io.*;

public class _A {
    static final int MOD = (int) 1e9 + 7;
    static int n, m;
    static long poss = 0;
    static boolean[][] reject = new boolean[7][7];
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        while (m-- > 0) {
            in.nextToken();
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            reject[a][b] = true;
            reject[b][a] = true;
        }
        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 4; ++j) {
                dfs(1, i, j);
            }
        }
        System.out.println(poss);
    }

    static void dfs(int dice, int face, int direc) {
        if (dice == n) {
            poss = poss + 1 % MOD;
            return;
        }
        for (int i = 1; i <= 6; ++i) {
            if (reject[face][i]) continue;
            for (int j = 1; j <= 4; ++j) {
                dfs(dice + 1, i, j);
            }
        }
    }
}
