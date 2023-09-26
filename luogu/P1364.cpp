#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 110;
int n;
int h[N], w[N], e[N * 2], ne[N * 2], idx;
int ans = 2e9;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int dfs(int dep, int u, int p) {
    int sum = w[u] * dep;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == p) continue;
        sum += dfs(dep + 1, v, u);
    }
    return sum;
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int p = 1; p <= n; ++p) {
        int u, v;
        scanf("%d%d%d", &w[p], &u, &v);
        if (u) add(p, u), add(u, p);
        if (v) add(p, v), add(v, p);
    }
    for (int u = 1; u <= n; ++u) ans = min(ans, dfs(0, u, -1));
    printf("%d\n", ans);

    return 0;
}