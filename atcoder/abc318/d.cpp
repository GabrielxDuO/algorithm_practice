#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 20;
int n;
int d[N][N];
bool vis[N];
LL ans = 0LL;

void dfs(int u, LL sum) {
    if (u > n) {
        ans = max(ans, sum);
        return;
    }
    if (!vis[u]) {
        vis[u] = true;
        for (int v = u + 1; v <= n; ++v) {
            if (!vis[v]) {
                vis[v] = true;
                dfs(u + 1, sum + d[u][v]);
                vis[v] = false;
            }
        }
        vis[u] = false;
    }
    dfs(u + 1, sum);
}

int main() {
    scanf("%d", &n);
    for (int u = 1; u < n; ++u) {
        for (int v = u + 1; v <= n; ++v) scanf("%d", &d[u][v]);
    }
    dfs(1, 0LL);
    printf("%lld\n", ans);

    return 0;
}