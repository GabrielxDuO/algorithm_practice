import java.util.*;
import java.io.*;

public class G_双向排序 {
    static final int N = (int) 1e5 + 10;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] stk = new int[N][2];
        int top = 0;
        while (m-- > 0) {
            in.nextToken();
            int p = (int) in.nval;
            in.nextToken();
            int q = (int) in.nval;
            if (p == 0) {
                while (top > 0 && stk[top][0] == 0) q = Math.max(q, stk[top--][1]);
                while (top >= 2 && stk[top - 1][1] <= q) top -= 2;
                stk[++top] = new int[]{0, q};
            } else if (top > 0) {
                while (top > 0 && stk[top][0] == 1) q = Math.min(q, stk[top--][1]);
                while (top >= 2 && stk[top - 1][1] >= q) top -= 2;
                stk[++top] = new int[]{1, q};
            }
        }
        int l = 1, r = n, k = n;
        int[] ans = new int[n + 1];
        for (int i = 1; i <= top; ++i) {
            if (stk[i][0] == 0) {
                while (r > stk[i][1] && l <= r) ans[r--] = k--; 
            } else {
                while (l < stk[i][1] && l <= r) ans[l++] = k--;
            }
            if (l > r) break;
        }
        if ((top & 1) == 0) {
            while (l <= r) ans[r--] = k--;
        } else {
            while (l <= r) ans[l++] = k--;
        }
        for (int i = 1; i <= n; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}
