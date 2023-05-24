import java.util.*;
import java.io.*;

public class _左移右移 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        Deque<int[]> ops = new LinkedList<>();
        while (m-- > 0) {
            in.nextToken();
            int dir = in.sval.charAt(0) == 'L' ? 0 : 1;
            in.nextToken();
            int x = (int) in.nval;
            ops.push(new int[]{dir, x});
        }
        int[] ans = new int[n];
        int l = 0, r = n - 1;
        boolean[] has = new boolean[n + 1];
        while (!ops.isEmpty()) {
            int[] op = ops.pop();
            int x = op[1];
            if (has[x]) continue;
            if (op[0] == 0) ans[l++] = x;
            else ans[r--] = x;
            has[x] = true;
        }
        for (int i = 1; i <= n; ++i) {
            if (!has[i]) ans[l++] = i;
        }
        for (int i = 0; i < n; ++i) System.out.print(ans[i] + " ");
    }
}
