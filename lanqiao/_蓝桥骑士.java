import java.util.*;
import java.io.*;

public class _蓝桥骑士 {
    static int cnt = 0;
    static int[] b;

    static int search(int l, int r, int x) {
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (b[m] < x) l = m;
            else r = m - 1;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        b = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int len = search(0, cnt, a[i]);
            cnt = Math.max(cnt, ++len);
            b[len] = a[i];
        }
        System.out.println(cnt);
    }
}
