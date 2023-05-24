import java.util.*;
import java.io.*;

public class _画中漂流 {
    static final int T = 3010, M = 1510, MOD = (int) 1e9 + 7;
    static int d, t, m;
    static int[][] memos = new int[T][M];
    static {
        for (int[] arr : memos) Arrays.fill(arr, -1);
    }

    static int dfs(int d, int t, int m) {
        if (memos[t][m] != -1) return memos[t][m];
        if (t == 0) {
            if (m != 0) return 0;
            return memos[0][0] = 1;
        }
        memos[t][m] = 0;
        if (m > 0) memos[t][m] = (memos[t][m] + dfs(d + 1, t - 1, m - 1)) % MOD;
        if (d > 1) memos[t][m] = (memos[t][m] + dfs(d - 1, t - 1, m)) % MOD;
        return memos[t][m];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int d = (int) in.nval;
        in.nextToken();
        int t = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        System.out.println(dfs(d, t, m));
    }
}
