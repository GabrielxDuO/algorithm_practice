import java.util.*;
import java.io.*;
import java.math.*;

public class _火柴棒数字 {
    static final int[] v = {0, 6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static int n = 10, c = 300;
    static String[][] f = new String[n + 1][c + 1];

    public static void main(String[] args) throws IOException {
        for (String[] arr : f) Arrays.fill(arr, "0");
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= c; ++j) {
                for (int k = 0; k <= 10 && k * v[i] <= j; ++k) {
                    String ns = new String(f[i - 1][j - k * v[i]]);
                    for (int a = 0; a < k; ++a) ns += (char) (i - 1 + '0');
                    char[] chs = ns.toCharArray();
                    Arrays.sort(chs);
                    ns = new String(chs);
                    ns = ns.substring(ns.lastIndexOf('0') + 1);
                    ns = new StringBuilder(ns).reverse().toString();
                    if (ns.isEmpty()) ns = "0";
                    if (new BigInteger(ns).compareTo(new BigInteger(f[i][j])) > 0) f[i][j] = ns;
                }
            }
        }
        System.out.println(f[n][c]);
    }
}
