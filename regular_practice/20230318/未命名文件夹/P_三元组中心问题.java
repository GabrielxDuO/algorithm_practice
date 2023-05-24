import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        boolean[] f = new boolean[n];
        int mn = 10001, mx = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            if (i > 0 && i < n - 1 && a[i] > mn) f[i] = true;
            mn = Math.min(mn, a[i]);
        }
        for (int i = n - 1; i > 0; --i) {
            if (f[i] && a[i] < mx) ++cnt;
            mx = Math.max(mx, a[i]);
        }
        System.out.println(cnt);
    }
}
