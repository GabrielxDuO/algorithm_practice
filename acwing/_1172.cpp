#include <cstdio>
#include <cstring>
#include <cmath>

using namespace std;

const int N = 4e4 + 10, K = log2(N) + 2, INF = 0x3f3f3f3f;
int n, m;
int root;
int h[N], e[N * 2], ne[N * 2], idx;
int dep[N], fa[N][K];
int que[N], hh, tt = -1;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void bfs(int u) {
    memset(dep, 0x3f, sizeof(dep));
    dep[0] = 0, dep[u] = 1;
    que[++tt] = u;
    while (hh <= tt) {
        u = que[hh++];
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dep[v] != INF) continue;
            dep[v] = dep[u] + 1;
            fa[v][0] = u;
            for (int k = 1; k < K; ++k) {
                fa[v][k] = fa[fa[v][k - 1]][k - 1];
            }
            que[++tt] = v;
        }
    }
}

int lca(int a, int b) {
    if (dep[a] < dep[b]) swap(a, b);
    for (int k = K - 1; k >= 0; --k) {
        if (dep[fa[a][k]] >= dep[b]) a = fa[a][k];
    }
    if (a == b) return a;
    for (int k = K - 1; k >= 0; --k) {
        if (fa[a][k] != fa[b][k]) {
            a = fa[a][k];
            b = fa[b][k];
        }
    }
    return fa[a][0];
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    while (n--) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (b == -1) {
            root = a;
            continue;
        }
        add(a, b), add(b, a);
    }
    bfs(root);
    scanf("%d", &m);
    while (m--) {
        int x, y;
        scanf("%d%d", &x, &y);
        int anc = lca(x, y);
        puts(anc == x ? "1" : (anc == y ? "2" : "0"));
    }
    
    return 0;
}