import java.util.*;
import java.io.*;

public class _024 {
    static final int N = (int) 1e4 + 10;
    static int n, k;
    static int[] roots = new int[N];
    static Set<Integer> st = new HashSet<>();

    public static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    public static void join(int p, int q) {
        roots[find(p)] = find(q);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int) in.nval;
        for (int i = 1; i < N; ++i) roots[i] = i;
        while (n-- > 0) {
            in.nextToken(); k = (int) in.nval;
            in.nextToken(); int x = (int) in.nval, y;
            st.add(x);
            while (--k > 0) {
                in.nextToken(); y = (int) in.nval;
                join(x, y);
                st.add(y);
            }
        }
        int group = 0;
        for (int x : st) {
            if (roots[x] == x) ++group;
        }
        StringBuilder ans = new StringBuilder();
        ans.append(String.format("%d %d\n", st.size(), group));
        in.nextToken(); k = (int) in.nval;
        while (k-- > 0) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            ans.append(find(a) == find(b) ? "Y\n" : "N\n");
        }
        out.print(ans);
        out.flush();
        out.close();
    }
}
