import java.util.*;
import java.io.*;


public class _N皇后 {
    static int n;
    static int[] queens;
    static int ans;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        queens = new int[n];
        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int curr) {
        if (curr == n) {
            ++ans;
            return;
        }
        outer: for (int col = 0; col < n; col++) {
            queens[curr] = col;
            for (int row = 0; row < curr; row++) {
                if (col == queens[row] ||
                        Math.abs(curr - row) == Math.abs(col - queens[row]))
                    continue outer;
            }
            dfs(curr + 1);
        }
    }
}


