import java.util.*;
import java.io.*;

public class _小明的彩灯 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        long[] diffs = new long[n + 2];
        while (q-- > 0) {
            in.nextToken();
            int l = (int) in.nval;
            in.nextToken();
            int r = (int) in.nval;
            in.nextToken();
            int x = (int) in.nval;
            diffs[l] += x;
            diffs[r + 1] -= x;
        }
        for (int i = 1; i <= n; ++i) {
            System.out.print(Math.max(0, a[i] + (diffs[i] += diffs[i - 1])) + " ");
        }
    }
}
