import java.util.*;
import java.io.*;

public class _最大子矩阵 {
    static final int N = (int) 1e5 + 10;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] g = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                in.nextToken();
                g[i][j] = (int) in.nval;
            }
        }
        in.nextToken();
        int lim = (int) in.nval;
        int ans = 0;
        int[] mxs = new int[m], mns = new int[m];
        for (int sx = 0; sx < n; ++sx) {
            Arrays.fill(mxs, 0);
            Arrays.fill(mns, N);
            for (int dx = sx; dx < n; ++dx) {
                for (int y = 0; y < m; ++y) {
                    mxs[y] = Math.max(mxs[y], g[dx][y]);
                    mns[y] = Math.min(mns[y], g[dx][y]);
                }
                int maxLen = 0;
                for (int sy = 0; sy < m && m - sy > maxLen; ++sy) {
                    int mx = sy, mn = sy;
                    for (int dy = sy; dy <= m && m - sy > maxLen; ++dy) {
                        if (mns[mn] > mns[dy]) mn = dy;
                        if (mxs[mx] < mxs[dy]) mx = dy;
                        if (mxs[mx] - mns[mn] > lim) {
                            sy = Math.min(mx, mn);
                            break;
                        } else maxLen = Math.max(maxLen, dy - sy + 1);
                    }
                }
                ans = Math.max(ans, maxLen * (dx - sx + 1));
            }
        }
        System.out.println(ans);
    }
}
