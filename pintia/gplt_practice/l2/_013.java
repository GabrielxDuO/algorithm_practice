import java.io.*;
import java.util.*;

public class _013 {
    static class UnionFind {
        private int[] roots;
        private int group;

        public UnionFind(int size) {
            roots = new int[size];
            group = size;
            for (int i = 0; i < size; i++) roots[i] = i;
        }

        public int find(int x) {
            return roots[x] == x ? x : (roots[x] = find(roots[x]));
        }

        public void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;
            roots[p] = q;
            --group;
        }

        public int getGroupCount() {
            return group;
        }
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        List<Integer>[] conn = new List[n];
        for (int i = 0; i < n; ++i) conn[i] = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            conn[a].add(b);
            conn[b].add(a);
        }
        in.nextToken(); int k = (int) in.nval;
        List<String> ans = new ArrayList<>();
        if (k == n) ans.add("Game Over.\n");
        int[] attacks = new int[k];
        boolean[] lost = new boolean[n];
        for (int i = 0; i < k; i++) {
            in.nextToken(); attacks[i] = (int) in.nval;
            lost[attacks[i]] = true;
        }
        UnionFind uf = new UnionFind(n);
        for (int u = 0; u < n; u++) {
            if (lost[u]) continue;
            for (int v : conn[u]) {
                if (!lost[v]) uf.union(u, v);
            }
        }
        int prev = uf.getGroupCount();
        for (int i = k - 1; i >= 0; i--) {
            int u = attacks[i];
            lost[u] = false;
            for (int v : conn[u]) {
                if (!lost[v]) uf.union(u, v);
            }
            if (prev - uf.getGroupCount() < 2) {
                ans.add("City " + u + " is lost.\n");
            } else {
                ans.add("Red Alert: City " + u + " is lost!\n");
            }
            prev = uf.getGroupCount();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i));
        }
        System.out.print(sb);
    }
}
