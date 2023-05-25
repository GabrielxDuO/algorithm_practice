#include <iostream>
#include <cstring>

using namespace std;

const int N = 110, INF = 0x3f3f3f3f;
int n;
int g[N][N];
int dists[N];
bool vis[N];

int prim() {
    memset(dists, 0x3f, sizeof(dists));
    int res = 0;
    for (int i = 0; i < n; ++i) {
        int mn = -1;
        for (int j = 1; j <= n; ++j) {
            if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
        }
        if (i) {
            if (dists[mn] == INF) return INF;
            res += dists[mn];
        }
        vis[mn] = true;
        for (int j = 1; j <= n; ++j) {
            dists[j] = min(dists[j], g[mn][j]);
        }
    }
    return res;
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            scanf("%d", &g[i][j]);
        }
    }
    printf("%d\n", prim());

    return 0;
}