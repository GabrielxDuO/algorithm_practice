import java.util.*;
import java.io.*;

public class B_区间不同数 {
    static int n, m;
    static int[] a, tr;

    static int lowbit(int x) {
        return x & -x;
    }

    static void add(int i, int x) {
        for (; i <= n; i += lowbit(i)) tr[i] += x;
    }

    static int query(int i) {
        int sum = 0;
        for (; i > 0; i -= lowbit(i)) sum += tr[i];
        return sum;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        a = new int[n + 1];
        tr = new int[n + 1];
        int mx = 0;
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
            mx = Math.max(mx, a[i]);
        }
        int[][] qs = new int[m][3];
        int[] anss = new int[m];
        for (int i = 0; i < m; ++i) {
            qs[i][0] = i;
            in.nextToken();
            qs[i][1] = (int) in.nval;
            in.nextToken();
            qs[i][2] = (int) in.nval;
        }
        Arrays.sort(qs, (a, b) -> a[2] - b[2]);
        int[] last = new int[mx + 1];
        int st = 1;
        for (int[] q : qs) {
            int id = q[0], l = q[1], r = q[2];
            for (int i = st; i <= r; ++i) {
                int curr = a[i];
                if (last[curr] != 0) add(last[curr], -1);
                add(i, 1);
                last[curr] = i;
            }
            anss[id] = query(r) - query(l - 1);
            st = r + 1;
        }
        for (int ans : anss) System.out.println(ans);
    }
}
