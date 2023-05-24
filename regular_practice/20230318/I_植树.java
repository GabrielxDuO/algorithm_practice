import java.util.*;
import java.io.*;

public class I_植树 {
    static int n;
    static int[][] trees;
    static boolean[] has;
    static boolean[][] clash;
    static int ans = 0;

    static boolean check(int a, int b) {
        int dx = trees[a][0] - trees[b][0];
        int dy = trees[a][1] - trees[b][1];
        int dist = trees[a][2] + trees[b][2];
        return dx * dx + dy * dy < dist * dist;
    }

    static void dfs(int idx, int s) {
        if (idx >= n) {
            ans = Math.max(ans, s);
            return;
        }
        dfs(idx + 1, s);
        for (int i = 0; i < idx; ++i) {
            if (has[i] && clash[i][idx]) return;
        }
        has[idx] = true;
        dfs(idx + 1, s + trees[idx][2] * trees[idx][2]);
        has[idx] = false;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        trees = new int[n][3];
        has = new boolean[n];
        clash = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            trees[i][0] = in.nextInt();
            trees[i][1] = in.nextInt();
            trees[i][2] = in.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (check(i, j)) clash[i][j] = clash[j][i] = true;
            }
        }
        dfs(0, 0);
        System.out.println(ans);
    }
}
