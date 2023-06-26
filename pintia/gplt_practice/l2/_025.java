import java.util.*;
import java.io.*;

public class _025 {
    static int n, m;
    static List<Integer>[] conn;
    static int[] roots;
    static Set<Integer> st = new HashSet<>();

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }

    static void join(int p, int q) {
        roots[find(p)] = find(q);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        conn = new List[n + 1];
        roots = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            conn[i] = new ArrayList<>();
            roots[i] = i;
        }
        int a, b;
        while (m-- > 0) {
            in.nextToken(); a = (int) in.nval;
            in.nextToken(); b = (int) in.nval;
            conn[a].add(b);
            conn[b].add(a);
        }
        int k, np;
        in.nextToken(); k = (int) in.nval;
        StringBuilder ans = new StringBuilder();
        outer: while (k-- > 0) {
            for (int i = 1; i <= n; ++i) {
                roots[i] = i;
            }
            in.nextToken(); np = (int) in.nval;
            st.clear();
            while (np-- > 0) {
                in.nextToken(); a = (int) in.nval;
                st.add(a);
            }
            for (int u = 1; u <= n; ++u) {
                if (st.contains(u)) continue;
                for (int v : conn[u]) {
                    if (!st.contains(v)) join(u, v);
                }
            }
            boolean flag = true;
            for (int u = 1; u <= n; ++u) {
                if (st.contains(u)) continue;
                if (roots[u] != u) {
                    ans.append("NO\n");
                    continue outer;
                }
            }
            ans.append("YES\n");
        }
        System.out.print(ans);
    }
}
