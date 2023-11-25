#include <cstdio>
#include <algorithm>
#include <cstring>

using namespace std;

const int N = 15;
int n, m;
int h[N], w[N * N], e[N * N], ne[N * N], idx;
int mx;
bool vis[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int d) {
    mx = max(mx, d);
    vis[u] = true;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (vis[v]) continue;
        dfs(v, d + w[i]);
    }
    vis[u] = false;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
    }
    for (int u = 1; u <= n; ++u) dfs(u, 0);
    printf("%d\n", mx);

    return 0;
}