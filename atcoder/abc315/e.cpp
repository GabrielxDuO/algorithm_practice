#include <cstdio>
#include <cstring>

using namespace std;

const int N = 2e5 + 10;
int n;
int h[2][N], e[2][N * 2], ne[2][N * 2], idx[2];
int ind[N];
int que[N], hh, tt = -1;
int R;
bool vis[N];

void add(int a, int b, int i) {
    e[i][idx[i]] = b, ne[i][idx[i]] = h[i][a], h[i][a] = idx[i]++;
}

void dfs(int u) {
    vis[u] = true;
    for (int i = h[1][u]; ~i; i = ne[1][i]) {
        int v = e[1][i];
        if (!vis[v]) dfs(v);
    }
}

void top_sort() {
    for (int u = 1; u <= n; ++u) {
        if (vis[u] && ind[u] == 0) que[++tt] = u;
    }
    while (hh <= tt) {
        int u = que[hh++];
        for (int i = h[0][u]; ~i; i = ne[0][i]) {
            int v = e[0][i];
            if (vis[v] && --ind[v] == 0) que[++tt] = v;
        }
    }
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int i = 1; i <= n; ++i) {
        int c, p; scanf("%d", &c);
        ind[i] = c;
        while (c--) {
            scanf("%d", &p);
            add(p, i, 0), add(i, p, 1);
        }
    }
    dfs(1);
    top_sort();
    for (int i = 0; i < tt; ++i) printf("%d ", que[i]);

    return 0;
}