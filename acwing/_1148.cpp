#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 510, M = 1e4 + 10;
int n, m;
struct Edge {
    int u, v, w;
    bool in_mst;

    bool operator<(const Edge& e) const {
        return w < e.w;
    }
} edges[M];
int roots[N];
int mx_dists[N][N], smx_dists[N][N];
int h[N], w[N * 2], e[N * 2], ne[N * 2], idx;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int p, int mx, int smx, int mxd[], int smxd[]) {
    mxd[u] = mx, smxd[u] = smx;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == p) continue;
        int tmx = mx, tsmx = smx;
        if (w[i] > tmx) tsmx = tmx, tmx = w[i];
        else if (w[i] < tmx && w[u] > tsmx) tsmx = w[i];
        dfs(v, u, tmx, tsmx, mxd, smxd);
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i)
        scanf("%d%d%d", &edges[i].u, &edges[i].v, &edges[i].w);
    sort(edges, edges + m);
    for (int i = 1; i <= n; ++i) roots[i] = i;
    LL sum = 0;
    memset(h, -1, sizeof(h));
    for (int i = 0; i < m; ++i) {
        int u = edges[i].u, v = edges[i].v, w = edges[i].w;
        if (find(u) != find(v)) {
            sum += w;
            join(u, v);
            add(u, v, w), add(v, u, w);
            edges[i].in_mst = true;
        }
    }
    for (int u = 1; u <= n; ++u) dfs(u, -1, -1e9, -1e9, mx_dists[u], smx_dists[u]);
    LL ans = 1e18;
    for (int i = 0; i < m; ++i) {
        if (edges[i].in_mst) continue;
        int u = edges[i].u, v = edges[i].v, w = edges[i].w;
        if (w > mx_dists[u][v]) ans = min(ans, sum + w - mx_dists[u][v]);
        else if (w > smx_dists[u][v]) ans = min(ans, sum + w - smx_dists[u][v]);
    }
    printf("%lld\n", ans);

    return 0;
}