import java.util.*;
import java.io.*;

public class _花店橱窗 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int v = (int) in.nval;
        int[][] w = new int[n + 1][v + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= v; ++j) {
                in.nextToken(); w[i][j] = (int) in.nval;
            }
        }
        int[][] f = new int[n + 1][v + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= v; ++j) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= v; ++j) {
                f[i][j] = f[i - 1][j - 1] + w[i][j];
                if (i < j) f[i][j] = Math.max(f[i][j], f[i][j - 1]);
            }
        }
        System.out.println(f[n][v]);
        Deque<Integer> stk = new LinkedList<>();
        for (int i = n, j = v; i != 0; --i, --j) {
            while (j >= 1 && f[i][j - 1] == f[i][j]) --j;
            stk.push(j);
        }
        while (!stk.isEmpty()) System.out.print(stk.pop() + " ");
    }
}
