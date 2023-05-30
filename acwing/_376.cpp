#include <iostream>
#include <cstring>

using namespace std;

const int N = 110;
int n, m, k;
bool g[N][N];
int vis[N];
int match[N];

bool find(int u) {
    for (int v = 1; v < m; ++v) {
        if (!g[u][v] || vis[v]) continue;
        vis[v] = true;
        if (match[v] == -1 || find(match[v])) {
            match[v] = u;
            return true;
        }
    }
    return false;
}

int main() {
    while (~scanf("%d%d%d", &n, &m, &k) && n) {
        memset(g, false, sizeof(g));
        while (k--) {
            int a, b;
            scanf("%*d%d%d", &a, &b);
            if (!a || !b) continue;
            g[a][b] = true;
        }
        int ans = 0;
        memset(match, -1, sizeof(match));
        for (int u = 1; u < n; ++u) {
            memset(vis, 0, sizeof(vis));
            if (find(u)) ++ans;
        }
        printf("%d\n", ans);
    }

    return 0;
}