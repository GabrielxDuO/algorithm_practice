import java.util.*;
import java.io.*;

public class _小明的背包2 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int c = (int) in.nval;
        int[] v = new int[n + 1], w = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            v[i] = (int) in.nval;
            in.nextToken();
            w[i] = (int) in.nval;
        }
        int[][] f = new int[n + 1][c + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= c; ++j) {
                f[i][j] = f[i - 1][j];
                if (v[i] <= j) f[i][j] = Math.max(f[i][j], f[i][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[n][c]);
    }
}
