import java.util.*;
import java.io.*;

public class _分考场 {
    static int n, m;
    static boolean[][] conn;
    static int[][] rooms;
    static int[] cnts;
    static int roomCnt, ans;

    static void dfs(int u) {
        if (roomCnt >= ans) return;
        if (u > n) {
            ans = roomCnt;
            return;
        }
        outer: for (int i = 0; i < roomCnt; ++i) {
            int[] curr = rooms[i];
            for (int j = 0; j < cnts[i]; ++j) {
                if (conn[u][curr[j]]) continue outer;
            }
            curr[cnts[i]++] = u;
            dfs(u + 1);
            --cnts[i];
        }
        int[] curr = rooms[roomCnt];
        curr[cnts[roomCnt]++] = u;
        ++roomCnt;
        dfs(u + 1);
         --roomCnt; --cnts[roomCnt];
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        conn = new boolean[n + 1][n + 1];
        rooms = new int[n][n];
        cnts = new int[n];
        ans = n;
        while (m-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            conn[a][b] = conn[b][a] = true;
        }
        dfs(1);
        System.out.println(ans);
    }
}
