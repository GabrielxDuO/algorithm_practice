import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] a, b;
    
    static int search(int l, int r, int x) {
        while (l <= r) {
            int m = l + r + 1 >> 1;
            System.out.println(m);
            if (b[m] < x) l = m;
            else r = m - 1;
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        a = new int[n]; b = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
        }
        int cnt = 1;
        for (int x : a) {
            int len = search(0, cnt, x);
            cnt = Math.max(cnt, len + 1);
            b[len + 1] = x;
        }
        System.out.println(cnt);
    }
}
