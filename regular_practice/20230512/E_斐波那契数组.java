import java.util.*;
import java.io.*;

public class E_斐波那契数组 {
    static final int N = 30;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int m = Math.min(n, N);
        int[] a = new int[m];
        for (int i = 0; i < m; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        int mx = 0;
        for (int st = 1; st <= a[0]; ++st) {
            int x = st, y = st, z = 0;
            int same = 0;
            if (a[0] == x) ++same;
            if (a[1] == y) ++same;
            for (int i = 2; i < m; ++i) {
                z = x + y;
                if (a[i] == z) ++same;
                x = y;
                y = z;
            }
            mx = Math.max(mx, same);
        }
        System.out.println(n - mx);
    }
}