#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n;
int h[N], w[N * 2], e[N * 2], ne[N * 2], idx;
LL dists[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int p, LL d) {
    dists[u] = d;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v != p) dfs(v, u, d + w[i]);
    }
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    LL ans = 0LL;
    for (int i = 0; i < n - 1; ++i) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
        ans += c * 2;
    }
    dfs(1, -1, 0);
    int mx_u = 1;
    for (int u = 1; u <= n; ++u) {
        if (dists[u] > dists[mx_u]) mx_u = u;
    }
    dfs(mx_u, -1, 0);
    LL mx = 0LL;
    for (int v = 1; v <= n; ++v) mx = max(mx, dists[v]);
    printf("%lld\n", ans - mx);

    return 0;
}