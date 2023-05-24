import java.util.*;
import java.io.*;

public class G_交通信号2 {
    static int MAX_N = 100000 + 10;
    static int MAX_M = 200000 + 10;
    static long INF = 0x3f3f3f3f3f3f3f3fL;

    static class Edge {
        public int v, g, r, d, next;
        public boolean drt;
        public long l;

        Edge(int v, int g, int r, int d, boolean drt) {
            this.v = v;
            this.g = g; this.r = r; this.d = d;
            this.l = (long) g + d + r + d;
            this.drt = drt;
        }
    }

    static class Node {
        int u;
        long dis;

        Node(int u, long dis) {
            this.u = u;
            this.dis = dis;
        }
    }

    static Edge[] edge = new Edge[MAX_M << 1];
    static int cnt = 0;
    static int[] head = new int[MAX_N];
    static long[] dis = new long[MAX_N];
    static boolean[] vis = new boolean[MAX_N];

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), s = in.nextInt(), t = in.nextInt(), u, v, g, r, d;
        Arrays.fill(head, -1);
        for (int i = 0; i < m; ++i) {
            u = in.nextInt(); v = in.nextInt();
            g = in.nextInt(); r = in.nextInt(); d = in.nextInt();
            addEdge(u, v, g, r, d, true);
            addEdge(v, u, g, r, d, false);
        }
        dijkstra(s);
        System.out.println(dis[t] >= INF ? -1 : dis[t]);
    }

    static void addEdge(int u, int v, int g, int r, int d, boolean drt) {
        edge[++cnt] = new Edge(v, g, r, d, drt);
        edge[cnt].next = head[u];
        head[u] = cnt;
    }

    static void dijkstra(int s) {
        Arrays.fill(dis, INF);
        Arrays.fill(vis, false);
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.dis != o2.dis) {
                return o1.dis - o2.dis > 0 ? 1 : -1;
            } else {
                return o1.u - o2.u;
            }
        });
        dis[s] = 0;
        q.offer(new Node(s, dis[s]));
        while (!q.isEmpty()) {
            Node p = q.poll();
            int u = p.u;
            if (vis[u]) {
                continue;
            }
            vis[u] = true;
            for (int i = head[u]; i != -1; i = edge[i].next) {
                int v = edge[i].v;
                long tmp = dis[u] + cal(edge[i], dis[u]);
                if (dis[v] > tmp) {
                    dis[v] = tmp;
                    if (vis[v]) {
                        vis[v] = false;
                    }
                    q.offer(new Node(v, dis[v]));
                }
            }
        }
    }

    static long cal(Edge e, long t) {
        long st = t % e.l, res = 0;
        if (e.drt) {
            if (st >= e.g) {
                res = e.l - st;
            }
        } else {
            if (st < e.g + e.d) {
                res = e.g + e.d - st;
            } else if (st >= (long) e.g + e.d + e.r) {
                res = e.l - st + e.g + e.d;
            }
        }
        return res + e.d;
    }
}
