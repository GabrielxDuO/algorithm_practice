import java.util.*;
import java.io.*;

public class _排列小球 {
    static int[] balls = new int[3];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int tot = 0;
        for (int i = 0; i < 3; ++i) {
            in.nextToken();
            balls[i] = (int) in.nval;
            tot += balls[i];
        }
        System.out.println(dfs(tot, 0, -1));
    }

    static int dfs(int remain, int prevNum, int prevColor) {
        if (remain == 0) return 1;
        int cnt = 0;
        for (int c = 0; c < 3; ++c) {
            if (c != prevColor) {
                for (int x = prevNum + 1; x <= balls[c]; ++x) {
                    balls[c] -= x;
                    cnt += dfs(remain - x, x, c);
                    balls[c] += x;
                }
            }
        }
        return cnt;
    }
}
