import java.util.*;
import java.io.*;

public class _聪明的美食家 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        int[] f = new int[n];
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            f[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (a[j] <= a[i]) f[i] = Math.max(f[i], f[j] + 1);
            }
            mx = Math.max(mx, f[i]);
        }
        System.out.println(mx);
    }
}
