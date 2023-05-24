import java.util.*;
import java.io.*;

public class _修剪公路 {
    static int n, m;
    static class Edge implements Comparable<Edge> {
        int u, v;
        long w;
        
        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.w, e.w);
        }
    }
    static int[] roots;
    static Edge[] edges;

    static int find(int x) {
        return roots[x] == x ? x : (roots[x] = find(roots[x]));
    }
    
    static void union(int p, int q) {
        roots[find(p)] = find(q);
    }
    
    static long kruskal() {
        Arrays.sort(edges);
        roots = new int[n + 1];
        for (int i = 1; i <= n; ++i) roots[i] = i;
        int cnt = 0;
        long res = 0;
        for (Edge edge : edges) {
            int u = edge.u, v = edge.v;
            long w = edge.w;
            if (find(u) != find(v)) {
                union(u, v);
                res += w;
                if (++cnt == n - 1) break;
            }
        }
        return cnt < n - 1 ? -1L : res;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        m = (int) in.nval;
        edges = new Edge[m];
        for (int i = 0; i < m; ++i) {
            in.nextToken();
            int u = (int) in.nval;
            in.nextToken();
            int v = (int) in.nval;
            in.nextToken();
            int w = (int) in.nval;
            edges[i] = new Edge(u, v, w);
        }
        System.out.println(kruskal());
    }
}
