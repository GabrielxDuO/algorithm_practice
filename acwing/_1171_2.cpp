#include <cstdio>
#include <cstring>
#include <cmath>
#include <queue>

using namespace std;

const int N = 1e4 + 10, M = 2e4 + 10, K = log2(N) + 1;
int n, m;
int h[N], w[M], e[M], ne[M], idx;
int dists[N];
int dep[N];
int fa[N][K];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void bfs() {
    memset(dep, 0x3f, sizeof(dep));
    dep[0] = 0, dep[1] = 1;
    queue<int> que;
    que.push(1);
    while (!que.empty()) {
        int u = que.front(); que.pop();
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dep[v] > dep[u] + 1) {
                dep[v] = dep[u] + 1;
                dists[v] = dists[u] + w[i];
                fa[v][0] = u;
                for (int k = 1; k < K; ++k) {
                    fa[v][k] = fa[fa[v][k - 1]][k - 1];
                }
                que.push(v);
            }
        }
    }
}

int lca(int a, int b) {
    if (dep[a] < dep[b]) swap(a, b);
    for (int i = K - 1; i >= 0; --i) {
        if (dep[fa[a][i]] >= dep[b]) a = fa[a][i];
    }
    if (a == b) return a;
    for (int i = K - 1; i >= 0; --i) {
        if (fa[a][i] != fa[b][i]) {
            a = fa[a][i];
            b = fa[b][i];
        }
    }
    return fa[a][0];
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n - 1; ++i) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
    }
    bfs();
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        int anc = lca(a, b);
        printf("%d\n", dists[a] + dists[b] - 2 * dists[anc]);
    }

    return 0;
}