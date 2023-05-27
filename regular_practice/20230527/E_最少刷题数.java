import java.util.*;
import java.io.*;

public class E_最少刷题数 {
    static int n;
    static int[] a, b;

    static int search(int x) {
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (b[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    static boolean check(int m) {
        int less = search(m), more = n - search(m + 1);
        return more <= less;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        b = a.clone();
        Arrays.sort(b);
        int l = b[0], r = b[n - 1];
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        int less = search(l), more = n - search(l + 1);
        int off = less > more ? 0 : 1;
        for (int x : a) {
            if (x < l) System.out.print(l + off - x + " ");
            else System.out.print("0 ");
        }
    }
}
