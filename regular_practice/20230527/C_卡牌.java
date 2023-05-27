import java.util.*;
import java.io.*;

public class C_卡牌 {
    static int n;
    static long m;
    static int[] a, b;

    static boolean check(int x) {
        long s = 0;
        for (int i = 0; i < n; ++i) {
            if (x - a[i] <= b[i]) {
                s += Math.max(0, x - a[i]);
            } else return false;
        }
        return s <= m;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (long) in.nval;
        a = new int[n]; b = new int[n];
        int l = 0, r = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        for (int i = 0; i < n; ++i) {
            in.nextToken(); b[i] = (int) in.nval;
            r = Math.min(r, a[i] + b[i]);
        }
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(l);
    }
}
