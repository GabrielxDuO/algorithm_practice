#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

const int N = 1e6 + 10, K = log2(N) + 2;
char s[N];
int m;
int pi[N];
bool vis[N];
int h[N], e[N], ne[N];
int idx, root;
int dep[N];
int fa[N][K];
int que[N], hh, tt = -1;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void bfs() {
    memset(dep, 0x3f, sizeof(dep));
    dep[0] = 0, dep[root] = 1;
    que[++tt] = root;
    while (hh <= tt) {
        int u = que[hh++];
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dep[v] > dep[u] + 1) {
                dep[v] = dep[u] + 1;
                fa[v][0] = u;
                for (int k = 1; k < K; ++k) {
                    fa[v][k] = fa[fa[v][k - 1]][k - 1];
                }
                que[++tt] = v;
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
    scanf("%s%d", s + 1, &m);
    int n = strlen(s + 1);
    memset(h, -1, sizeof(h));
    pi[1] = 0;
    for (int i = 2, j = 0; i <= n; ++i) {
        while (j > 0 && s[i] != s[j + 1]) j = pi[j];
        if (s[i] == s[j + 1]) ++j;
        pi[i] = j;
    }
    for (int i = n; i >= 1; --i) {
        if (vis[i]) continue;
        vis[i] = true;
        for (int j = i; j;) {
            // add(j, pi[j]);
            add(pi[j], j);
            if (vis[j]) break;
            vis[j] = true;
            j = pi[j];
        }
    }
    root = 0;
    bfs();
    while (m--) {
        int p, q;
        scanf("%d%d", &p, &q);
        int ans = lca(p, q);
        if (ans == p || ans == q) ans = fa[ans][0];
        printf("%d\n", ans);
    }

    return 0;
}