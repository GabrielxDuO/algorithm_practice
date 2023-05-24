import java.util.*;
import java.io.*;

public class K_外卖店优先级 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int t = (int) in.nval;
        int[][] orders = new int[m][2];
        for (int i = 0; i < m; ++i) {
            in.nextToken();
            int ts = (int) in.nval;
            in.nextToken();
            int id = (int) in.nval;
            orders[i] = new int[]{ts, id};
        }
        Arrays.sort(orders, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] pris = new int[n + 1], lasts = new int[n + 1];
        boolean[] inPris = new boolean[n + 1];
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            int ts = orders[i][0], id = orders[i][1];
            int pri = pris[id];
            pri = Math.max(0, pri - (ts - lasts[id] - 1));
            if (pri <= 3 && inPris[id]) {
                inPris[id] = false;
                --cnt;
            }
            lasts[id] = ts;
            int j = i + 1;
            while (j < m && orders[j][1] == id && orders[j][0] == ts) ++j;
            pri += (j - i) * 2;
            if (pri > 5 && !inPris[id]) {
                inPris[id] = true;
                ++cnt;
            }
            pris[id] = pri;
            i = j - 1;
        }
        for (int i = 1; i <= n; ++i) {
            if (!inPris[i]) continue;
            if (pris[i] - (t - lasts[i]) <= 3) --cnt;
        }
        System.out.println(cnt);
    }
}
