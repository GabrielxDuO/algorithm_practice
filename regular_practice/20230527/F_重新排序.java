import java.util.*;
import java.io.*;

public class F_重新排序 {
    static int n, m;
    static int[] a;
    static long[] s;
    static int[][] qs;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n + 1];
        s = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
            s[i] = s[i - 1] + a[i];
        }
        in.nextToken(); m = (int) in.nval;
        qs = new int[m][2];
        int[] d = new int[n + 2];
        long oriSum = 0L;
        for (int i = 0; i < m; ++i) {
            in.nextToken(); int l = (int) in.nval;
            in.nextToken(); int r = (int) in.nval;
            qs[i][0] = l; qs[i][1] = r;
            ++d[l]; --d[r + 1];
            oriSum += s[r] - s[l - 1];
        }
        int[][] poses = new int[n + 1][2];
        for (int i = 1; i <= n; ++i) {
            d[i] += d[i - 1]; 
            poses[i][0] = i;
            poses[i][1] = d[i];
        }
        Arrays.sort(poses, (x, y) -> x[1] - y[1]);
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        for (int i = 1; i <= n; ++i) {
            a[poses[i][0]] = sorted[i];
        }
        for (int i = 1; i <= n; ++i) s[i] = s[i - 1] + a[i];
        long newSum = 0L;
        for (int[] q : qs) {
            newSum += s[q[1]] - s[q[0] - 1];
        }
        System.out.println(newSum - oriSum);
    }
}
