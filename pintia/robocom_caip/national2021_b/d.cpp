#include <cstdio>
#include <cstring>

using namespace std;

const int N = 15;
int cats[N];
int g[N][N];
int n, m;
bool used[N];
int chosen[N];
int mn, ans[N];

void dfs(int u) {
    if (u >= mn) return;
    bool ap = true;
    for (int i = 1; i <= n; ++i) {
        if (cats[i] != 1) {
            ap = false;
            break;
        }
    }
    if (ap) {
        memcpy(ans, chosen, sizeof(ans));
        mn = u;
        return;
    }
    int bak[N];
    for (int i = 1; i <= m; ++i) {
        if (used[i]) continue;
        memcpy(bak, cats, sizeof(bak));
        for (int j = 1; j <= n; ++j) {
            if (g[i][j]) cats[j] = g[i][j];
        }
        chosen[u] = i;
        used[i] = true;
        dfs(u + 1);
        used[i] = false;
        memcpy(cats, bak, sizeof(cats));
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) scanf("%d", &g[i][j]);
    }
    memset(cats, -1, sizeof(cats));
    mn = m + 1;
    dfs(0);
    for (int i = 0; i < mn; ++i) {
        printf("%d", ans[i]);
        printf(i == mn - 1 ? "\n" : " ");
    }

    return 0;
}