#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 210, M = N * N * 2, INF = 0x3f3f3f3f;
int n, m, k;
int g[N][N];
bool vis[N];
int path[N];
int mn = INF, mn_idx, cnt;

bool check(int t) {
    int cost = 0;
    for (int i = 0; i < n; ++i) cost += g[path[i]][path[i + 1]];
    cost += g[path[n]][0];
    if (cost < mn) {
        mn = cost;
        mn_idx = t;
    }
    return cost < INF;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(g, 0x3f, sizeof(g));
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        g[a][b] = g[b][a] = min(g[a][b], c);
    }
    scanf("%d", &k);
    for (int i = 1; i <= k; ++i) {
        int nn; scanf("%d", &nn);
        if (nn != n) {
            while (nn--) scanf("%*d");
            continue;
        }
        memset(vis, false, sizeof(vis));
        vis[0] = true;
        bool invalid = false;
        for (int j = 1; j <= n; ++j) {
            scanf("%d", &path[j]);
            if (vis[path[j]]) invalid = true;
            else vis[path[j]] = true;
        }
        if (invalid || g[0][path[1]] == INF || g[path[n]][0] == INF || !check(i)) continue;
        ++cnt;
    }
    printf("%d\n%d %d\n", cnt, mn_idx, mn);

    return 0;
}