import java.util.*;
import java.io.*;

public class P_最长不下降子序列 {
    static int n, k;
    static int[] a, b, bak;
    
    static int search(int l, int r, int x) {
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (x >= b[m]) l = m;
            else r = m - 1;
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        bak = new int[n];
        b = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            bak[i] = (int) in.nval;
        }
        int ans = 0;
        for (int i = 1; i + k < n; ++i) {
            int[] a = bak.clone();
            Arrays.fill(b, 0);
            int prev = a[i - 1];
            for (int j = 0; j < k; ++j) a[i + j] = prev;
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                int len = search(0, cnt, a[j]);
                cnt = Math.max(cnt, ++len);
                b[len] = a[j];
            }
            ans = Math.max(cnt, ans);
        }
        System.out.println(ans);
    }
}