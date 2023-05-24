import java.util.*;
import java.io.*;

public class _G {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        List<int[]> stk = new ArrayList<>();
        while (m-- > 0) {
            in.nextToken();
            int p = (int) in.nval;
            in.nextToken();
            int q = (int) in.nval;
            if (p == 0) {
                while (!stk.isEmpty() && stk.get(stk.size() - 1)[0] == 0) q = Math.max(q, stk.remove(stk.size() - 1)[1]);
                while (stk.size() >= 2 && stk.get(stk.size() - 2)[1] <= q) {
                    stk.remove(stk.size() - 1);
                    stk.remove(stk.size() - 1);
                }
                stk.add(new int[]{0, q});
            } else if (!stk.isEmpty()) {
                while (!stk.isEmpty() && stk.get(stk.size() - 1)[0] == 1) q = Math.min(q, stk.remove(stk.size() - 1)[1]);
                while (stk.size() >= 2 && stk.get(stk.size() - 2)[1] >= q) {
                    stk.remove(stk.size() - 1);
                    stk.remove(stk.size() - 1);
                }
                stk.add(new int[]{1, q});
            }
        }
        int l = 1, r = n, k = n;
        int[] ans = new int[n + 1];
        for (int[] pr : stk) {
            if (pr[0] == 0) {
                while (r > pr[1] && l <= r) ans[r--] = k--; 
            } else {
                while (l < pr[1] && l <= r) ans[l++] = k--;
            }
            if (l > r) break;
        }
        if ((stk.size() & 1) == 0) {
            while (l <= r) ans[r--] = k--;
        } else {
            while (l <= r) ans[l++] = k--;
        }
        for (int i = 1; i <= n; ++i) {
            System.out.print(ans[i] + " ");
        }
    }
}
