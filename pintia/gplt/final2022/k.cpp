#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, m;
int root;
int fa[N], dists[N];
int ans = 0, mx = 0;

int dfs(int u) {
    if (~dists[u]) return dists[u]; 
    ++ans;
    return dists[u] = dfs(fa[u]) + 1;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int u = 1; u <= n; ++u) {
        scanf("%d", &fa[u]);
        if (fa[u] == -1) root = u;
    }
    memset(dists, -1, sizeof(dists));
    dists[root] = 0;
    while (m--) {
        int x; scanf("%d", &x);
        mx = max(mx, dfs(x));
        printf("%d\n", ans * 2 - mx);
    }

    return 0;
}