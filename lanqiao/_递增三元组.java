import java.util.*;
import java.io.*;

public class _递增三元组 {
    static int n;
    static int[][] g;

    static int leftBound(int i, int x) {
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (g[i][m] >= x) r = m;
            else l = m + 1;
        }
        return g[i][l] >= x ? l : n;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        g = new int[3][n];
        for (int[] arr : g) {
            for (int i = 0; i < n; ++i) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            Arrays.sort(arr);
        }
        long cnt = 0;
        for (int i = 0; i < n; ++i) {
            int b = g[1][i];
            int ai = leftBound(0, b);
            int ci = n - leftBound(2, b + 1);
            cnt += 1L * ai * ci;
        }
        System.out.println(cnt);
    }
}
