import java.util.*;
import java.io.*;

public class _102 {
    static final double EPS = 1e-6;
    static int n, f;
    static int[] a;
    static double[] s;

    static boolean check(double m) {
        for (int i = 1; i <= n; ++i) s[i] = s[i - 1] + (a[i] - m);
        double mn = 0.0;
        for (int r = f; r <= n; ++r) {
            int l = r + 1 - f;
            mn = Math.min(mn, s[l - 1]);
            if (s[r] - mn >= 0) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); f = (int) in.nval;
        a = new int[n + 1];
        s = new double[n + 1];
        int mx = 0;
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
            mx = Math.max(mx, a[i]);
        }
        double l = 0.0, r = mx;
        while (r - l > EPS) {
            double m = (l + r) / 2;
            if (check(m)) l = m;
            else r = m;
        }
        System.out.println((long) (r * 1000));
    }
}
