import java.util.*;
import java.io.*;

public class _闯关 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        in.nextToken(); int p = (int) in.nval;
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); v[i] = (int) in.nval;
        }
        long[] f = new long[n + 1];
        f[1] = v[1] - p;
        for (int i = 2; i <= n; ++i) {
            f[i] = Long.MIN_VALUE;
            for (int j = Math.max(1, i - m); j < i; ++j) {
                f[i] = Math.max(f[i], f[j] + v[i] - p);
            }
        }
        System.out.println(f[n]);
    }
}
