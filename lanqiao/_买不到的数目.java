import java.util.*;
import java.io.*;

public class _买不到的数目 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = 2;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        int c = 1000 * 1000;
        boolean[] f = new boolean[c];
        f[0] = true;
        for (int i = 0; i < n; ++i) {
            for (int j = a[i]; j < c; ++j) {
                f[j] |= f[j - a[i]];
            }
        }
        int ans = 0;
        for (int i = 1; i < c; ++i) {
            if (!f[i]) ans = i;
        }
        System.out.println(ans);
    }
}
