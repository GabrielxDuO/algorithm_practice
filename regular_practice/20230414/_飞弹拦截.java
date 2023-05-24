import java.util.*;
import java.io.*;

public class _飞弹拦截 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        in.nextToken(); int m = (int) in.nval;
        boolean[] must = new boolean[n];
        while (m-- > 0) {
            in.nextToken(); int x = (int) in.nval;
            must[x] = true;
        }
        int[] f = new int[n];
        int prev = 0;
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            for (int j = prev; j < i; ++j) {
                if (prev > 0 && f[j] == 1 && !must[j]) continue;
                if (a[j] <= a[i]) f[i] = Math.max(f[i], f[j] + 1);
            }
            if (must[i]) prev = i;
        }
        int ans = 0;
        // for (int i = 0; i < n; ++i) {
        //     System.out.print(f[i] + " ");
        // }
        // System.out.println();
        for (int i = prev; i < n; ++i) ans = Math.max(ans, f[i]);
        System.out.println(ans);
    }
}
