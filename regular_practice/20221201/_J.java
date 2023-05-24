import java.util.*;
import java.io.*;

public class _J {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int t = (int) in.nval;
        int[] pris = new int[n + 1];
        boolean[] inPriQue = new boolean[n + 1];
        int[] prevs = new int[n + 1];
        int[][] orders = new int[m][2];
        for (int i = 0; i < m; ++i) {
            in.nextToken();
            orders[i][0] = (int) in.nval;
            in.nextToken();
            orders[i][1] = (int) in.nval;
        }
        Arrays.sort(orders, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            int st = orders[i][0], id = orders[i][1];
            int pri = pris[id];
            pri = Math.max(pri - (st - prevs[id] - 1), 0);
            if (pri <= 3 && inPriQue[id]) {
                inPriQue[id] = false;
                --cnt;
            }
            prevs[id] = st;
            int j = i + 1;
            while (j < m && orders[j][0] == st && orders[j][1] == id) ++j;
            pri += (j - i) * 2;
            if (pri > 5 && !inPriQue[id]) {
                inPriQue[id] = true;
                ++cnt;
            }
            pris[id] = pri;
            i = j - 1;
        }
        for (int i = 1; i <= n; ++i) {
            if (!inPriQue[i]) continue;
            if (pris[i] - (t - prevs[i]) <= 3) --cnt;
        }
        System.out.println(cnt);
    }
}
