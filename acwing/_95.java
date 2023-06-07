import java.util.*;
import java.io.*;

public class _95 {
    static final int N = 5, M = 1 << N;
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] g = new boolean[N][N], bak = new boolean[N][N];

    static void turn(int x, int y) {
        g[x][y] ^= true;
        for (int[] DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) g[nx][ny] ^= true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            for (int i = 0; i < N; ++i) {
                String s = br.readLine();
                for (int j = 0; j < N; ++j) bak[i][j] = s.charAt(j) == '1';
            }
            br.readLine();
            int ans = 7;
            outer: for (int s = 0; s < M; ++s) {
                for (int i = 0; i < N; ++i) g[i] = bak[i].clone();
                int cnt = 0;
                for (int i = 0; i < N; ++i) {
                    if ((s >> i & 1) == 1) {
                        turn(0, i);
                        ++cnt;
                    }
                }
                for (int i = 1; i < N; ++i) {
                    for (int j = 0; j < N; ++j) {
                        if (!g[i - 1][j]) {
                            turn(i, j);
                            ++cnt;
                        }
                    }
                }
                for (int i = 0; i < N; ++i) {
                    if (!g[N - 1][i]) continue outer;
                }
                ans = Math.min(ans, cnt);
            }
            System.out.println(ans > 6 ? -1 : ans);
        }
    }
}
