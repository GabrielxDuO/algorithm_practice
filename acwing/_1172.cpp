#include <cstdio>
#include <cmath>
#include <cstring>
#include <queue>

using namespace std;

const int N = 4e4 + 10, M = N * 2, K = (int) log2(N) + 1;
int n, m;
int h[N], e[M], ne[M], idx;
int dep[N], fa[N][K];
int root;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void bfs() {
    memset(dep, 0x3f, sizeof(dep));
    dep[0] = 0, dep[root] = 1;
    queue<int> que;
    que.push(root);
    while (!que.empty()) {
        int u = que.front(); que.pop();
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dep[v] > dep[u] + 1) {
                dep[v] = dep[u] + 1;
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
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (b == -1) root = a;
        add(a, b), add(b, a);
    }
    bfs();
    scanf("%d", &m);
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        int anc = lca(a, b);
        puts(anc == a ? "1" : (anc == b ? "2" : "0"));
    }

    return 0;
}