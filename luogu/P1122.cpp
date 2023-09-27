#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1.6e4 + 10, NEG_INF = 1 << 31;
int n;
int h[N], w[N], e[N * 2], ne[N * 2], idx;
int f[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int p) {
    f[u] = w[u];
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == p) continue;
        dfs(v, u);
        f[u] = max(f[u], f[u] + f[v]);
    }
}

int main() {
    scanf("%d", &n);
    for (int u = 1; u <= n; ++u) scanf("%d", &w[u]);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n - 1; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b), add(b, a);
    }
    dfs(1, -1);
    int ans = NEG_INF;
    for (int u = 1; u <= n; ++u) ans = max(ans, f[u]);
    printf("%d\n", ans);

    return 0;
}