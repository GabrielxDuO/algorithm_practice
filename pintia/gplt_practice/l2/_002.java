import java.util.*;
import java.io.*;

public class _002 {
    static final int N = (int) 1e5 + 10, M = (int) 1e4 + 10;
    static int head, n, dummy1 = N - 1, dummy2 = N - 2;
    static int[] e = new int[N], ne1 = new int[N], ne2 = new int[N];
    static boolean[] vis = new boolean[M];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); head = (int) in.nval;
        in.nextToken(); n = (int) in.nval;
        ne1[dummy1] = head;
        while (n-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int c = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            e[a] = c;
            ne1[a] = b;
        }
        int prev1 = dummy1, prev2 = dummy2;
        for (int i = ne1[dummy1]; i != -1; i = ne1[i]) {
            int val = Math.abs(e[i]);
            if (vis[val]) {
                ne2[prev2] = i;
                prev2 = i;
                ne1[prev1] = ne1[i];
            } else {
                vis[val] = true;
                prev1 = i;
            }
        }
        ne2[prev2] = -1;
        StringBuilder ans = new StringBuilder();
        for (int i = ne1[dummy1]; i != -1; i = ne1[i]) {
            ans.append(String.format("%05d %d ", i, e[i]));
            if (ne1[i] != -1) ans.append(String.format("%05d\n", ne1[i]));
            else ans.append("-1\n");
        }
        for (int i = ne2[dummy2]; i != -1; i = ne2[i]) {
            ans.append(String.format("%05d %d ", i, e[i]));
            if (ne2[i] != -1) ans.append(String.format("%05d\n", ne2[i]));
            else ans.append("-1\n");
        }
        out.print(ans);
        out.flush();
        out.close();
    }
}
