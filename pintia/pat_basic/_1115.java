import java.util.*;
import java.io.*;

public class _1115 {
    static final int N = (int) 1e5 + 10;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int a = (int) in.nval;
        in.nextToken(); int b = (int) in.nval;
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        boolean[] st = new boolean[N];
        boolean[] isOut = new boolean[n + 1];
        int[][] g = new int[n + 1][m + 1];
        int winnerCnt = 0;
        int mn = Math.min(a, b), mx = Math.max(a, b);
        st[a] = st[b] = true;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                in.nextToken(); g[i][j] = (int) in.nval;
            }
        }
        winnerCnt = n;
        for (int k = 1; k <= m; ++k) {
            for (int i = 1; i <= n; ++i) {
                if (isOut[i]) continue;
                int z = g[i][k];
                boolean out = true;
                if (!st[z]) {
                    for (int x = mn; x < mx; ++x) {
                        if (!st[x]) continue;
                        int y = x + z;
                        if (y > 0 && y < N && st[y]) {
                            out = false;
                            break;
                        }
                    }
                }
                if (out) {
                    isOut[i] = true;
                    --winnerCnt;
                    ans.append(String.format("Round #%d: %d is out.\n", k, i));
                } else {
                    st[z] = true;
                    if (z < mn) mn = z;
                    else if (z > mx) mx = z;
                }
            }
        }
        if (winnerCnt == 0) ans.append("No winner.");
        else {
            ans.append("Winner(s):");
            for (int i = 1; i <= n; ++i) {
                if (!isOut[i]) ans.append(" " + i);
            }
        }
        System.out.println(ans);
    }
}
