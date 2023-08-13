#include <cstdio>
#include <cstring>
#include <algorithm>
#include <unordered_map>
#include <vector>
#include <set>

using namespace std;

const int N = 210, INF = 0x3f3f3f3f, M = N * N;
int n, m, k, q;
int d[N][N];
bool is_trm[N];
int h[N], e[M], ne[M], idx;
bool vis[N];

void floyd() {
    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }
}

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u) {
    vis[u] = true;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (!vis[v]) dfs(v);
    }
}

int main() {
    scanf("%d%d%d\n", &n, &m, &k);
    memset(d, 0x3f, sizeof(d));
    memset(h, -1, sizeof(h));
    for (int i = 1; i <= n; ++i) d[i][i] = 0;
    while (m--) {
        int u, v, w;
        scanf("%d", &u);
        is_trm[u] = true;
        while (getchar() == ' ' && ~scanf("%d%d", &w, &v)) {
            d[u][v] = d[v][u] = min(d[u][v], w);
            u = v;
        }
        is_trm[u] = true;
    }
    floyd();
    for (int u = 1; u <= n; ++u) {
        unordered_map<int, int> mx_dist;
        for (int v = 1; v <= n; ++v) {
            if (u == v) continue;
            if (d[u][v] != INF) {
                int cost = d[u][v] / k + 2;
                mx_dist[cost] = max(mx_dist[cost], d[u][v]);
            }
        }
        for (int v = 1; v <= n; ++v) {
            if (u == v) continue;
            int cost = d[u][v] / k + 2;
            if (d[u][v] == mx_dist[cost] || d[u][v] != INF && is_trm[v]) add(u, v);
        }
    }
    scanf("%d", &q);
    while (q--) {
        int st; scanf("%d", &st);
        memset(vis, false, sizeof(vis));
        dfs(st);
        set<int> ans;
        for (int u = 1; u <= n; ++u) {
            if (vis[u]) {
                ans.insert(u);
            }
        }
        bool is_first = true;
        for (int u : ans) {
            if (is_first) is_first = false;
            else printf(" ");
            printf("%d", u);
        }
        puts("");
    }

    return 0;
}