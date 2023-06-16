import java.io.*;
import java.util.*;

public class _015 {
    static final int N = 10010, M = 25;
    static int n, k, m;
    static double[] a = new double[N];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        for (int i = 0; i < n; ++i) {
            int sum = 0, mn = 101, mx = -1;
            for (int j = 0; j < k; ++j) {
                in.nextToken();
                int x = (int) in.nval;
                sum += x;
                mn = Math.min(mn, x);
                mx = Math.max(mx, x);
            }
            sum = sum - mn - mx;
            a[i] = sum * 1.0 / (k - 2);
        }
        Arrays.sort(a, 0, n);
        for (int i = Math.max(0, n - m); i < n; ++i) {
            System.out.printf("%.3f", a[i]);
            System.out.print(i == n - 1 ? "\n" : " ");
        }
    }
}
