import java.util.*;
import java.io.*;

public class A_双向排序 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        int[][] stk = new int[m + 1][2];
        int tt = 0;
        while (m-- > 0) {
            in.nextToken(); int p = (int) in.nval;
            in.nextToken(); int q = (int) in.nval;
            if (p == 0) {
                while (tt > 0 && stk[tt][0] == p) q = Math.max(q, stk[tt--][1]);
                while (tt >= 2 && stk[tt - 1][1] <= q) tt -= 2;
                stk[++tt] = new int[]{p, q};
            } else if (tt > 0) {
                while (tt > 0 && stk[tt][0] == p) q = Math.min(q, stk[tt--][1]);
                while (tt >= 2 && stk[tt - 1][1] >= q) tt -= 2;
                stk[++tt] = new int[]{p, q};
            }
        }
        int[] ans = new int[n + 1];
        int k = n, l = 1, r = n;
        for (int i = 1; i <= tt; ++i) {
            if (stk[i][0] == 0) {
                while (r > stk[i][1] && l <= r) ans[r--] = k--;
            } else {
                while (l < stk[i][1] && l <= r) ans[l++] = k--;
            }
            if (l > r) break;
        }
        if ((tt & 1) == 0) {
            while (l <= r) ans[r--] = k--;
        } else {
            while (l <= r) ans[l++] = k--;
        }
        for (int i = 1; i <= n; ++i) System.out.print(ans[i] + " ");
    }
}
