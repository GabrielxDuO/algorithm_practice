#include <iostream>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 110, INF = 0x3f3f3f3f;
int n, m;
int g[N][N], d[N][N];
int mid[N][N];
int path[N], len;
int mn = INF;

void dfs(int i, int j) {
    int k = mid[i][j];
    if (!k) return;
    dfs(i, k);
    path[len++] = k;
    dfs(k, j);
}

void floyd() {
    memcpy(d, g, sizeof(d));
    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i < k; ++i) {
            for (int j = i + 1; j < k; ++j) {
                LL dist = 1L * d[i][j] + g[j][k] + g[k][i];
                if (dist < mn) {
                    mn = dist;
                    len = 0;
                    path[len++] = k;
                    path[len++] = i;
                    dfs(i, j);
                    path[len++] = j;
                }
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (d[i][k] + d[k][j] < d[i][j]) {
                    d[i][j] = d[i][k] + d[k][j];
                    mid[i][j] = k;
                }
            }
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(g, 0x3f, sizeof(g));
    for (int u = 1; u <= n; ++u) g[u][u] = 0;
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        g[a][b] = g[b][a] = min(g[a][b], c);
    }
    floyd();
    if (mn == INF) {
        puts("No solution.");
        return 0;
    }
    for (int i = 0; i < len; ++i) printf("%d ", path[i]);

    return 0;
}