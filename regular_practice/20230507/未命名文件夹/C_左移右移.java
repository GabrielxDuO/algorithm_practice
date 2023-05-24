import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        int[][] ops = new int[m][2];
        for (int i = 0; i < m; ++i) {
            in.nextToken(); ops[i][0] = in.sval.charAt(0) == 'L' ? 0 : 1;
            in.nextToken(); ops[i][1] = (int) in.nval;
        }
        int[] a = new int[n];
        boolean[] vis = new boolean[n + 1];
        int l = 0, r = n - 1;
        for (int i = m - 1; i >= 0; --i) {
            if (!vis[ops[i][1]]) {
                if (ops[i][0] == 0) a[l++] = ops[i][1];
                else a[r--] = ops[i][1];
                vis[ops[i][1]] = true;
            }
        }
        for (int x = 1; x <= n; ++x) {
            if (!vis[x]) a[l++] = x;
        }
        for (int x : a) System.out.print(x + " ");
    }
}
