#include <cstdio>
#include <cstring>
#include <utility>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;
typedef long long LL;

const int N = 2e5 + 10;
int n, m;
int h[N], e[N * 2], ne[N * 2], idx;
PII w[N * 2];
bool vis[N];
LL pos[N][2];

void add(int a, int b, int x, int y) {
    e[idx] = b, w[idx] = {x, y}, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u) {
    vis[u] = true;
    const LL& x = pos[u][0], & y = pos[u][1];
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (vis[v]) continue;
        pos[v][0] = x + w[i].fi;
        pos[v][1] = y + w[i].se;
        dfs(v);
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b, x, y;
        scanf("%d%d%d%d", &a, &b, &x, &y);
        add(a, b, x, y), add(b, a, -x, -y);
    }
    dfs(1);
    for (int u = 1; u <= n; ++u) {
        if (vis[u]) printf("%lld %lld\n", pos[u][0], pos[u][1]);
        else puts("undecidable");
    }

    return 0;
}