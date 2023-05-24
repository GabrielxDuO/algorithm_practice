import java.util.*;
import java.io.*;

public class F_矩形拼接 {
    static int[][] rects = new int[3][2];

    static void solve() {
        int ans = 8;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (j == i) continue;
                int k = 3 - i - j;
                for (int a = 0; a < 2; ++a) {
                    for (int b = 0; b < 2; ++b) {
                        for (int c = 0; c < 2; ++c) {
                            if (rects[i][a] == rects[j][b] + rects[k][c]) {
                                ans = Math.min(ans, 6);
                                if (rects[j][b ^ 1] == rects[k][c ^ 1]) ans = Math.min(ans, 4);
                            }
                            if (rects[i][a] == rects[j][b] || rects[i][a] == rects[k][c]) {
                                ans = Math.min(ans, 6);
                                if (rects[i][a] == rects[j][b] && rects[i][a] == rects[k][c]) ans = Math.min(ans, 4);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); rects[0][0] = (int) in.nval;
            in.nextToken(); rects[0][1] = (int) in.nval;
            in.nextToken(); rects[1][0] = (int) in.nval;
            in.nextToken(); rects[1][1] = (int) in.nval;
            in.nextToken(); rects[2][0] = (int) in.nval;
            in.nextToken(); rects[2][1] = (int) in.nval;
            solve();
        }
    }
}
