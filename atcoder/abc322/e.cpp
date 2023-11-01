#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 110, K = 6;
const LL INF = 0x3f3f3f3f3f3f3f3fLL;
int n, k, P;
int c[N], p[K], a[N][K];
LL f[K][K][K][K][K];

// 多维费用(每维费用有至少需求值)求最小价值的01背包问题 类似[潜水员](https://gabrielxd.top/archives/acwing-1020)
int main() {
    scanf("%d%d%d", &n, &k, &P);
    for (int i = 1; i <= k; ++i) p[i] = P;
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &c[i]);
        for (int j = 1; j <= k; ++j) scanf("%d", &a[i][j]);
    }
    memset(f, 0x3f, sizeof(f));
    f[0][0][0][0][0] = 0LL;
    for (int i = 1; i <= n; ++i) {
        for (int x1 = p[1]; x1 >= 0; --x1) {
            for (int x2 = p[2]; x2 >= 0; --x2) {
                for (int x3 = p[3]; x3 >= 0; --x3) {
                    for (int x4 = p[4]; x4 >= 0; --x4) {
                        for (int x5 = p[5]; x5 >= 0; --x5) {
                            int v1 = max(0, x1 - a[i][1]);
                            int v2 = max(0, x2 - a[i][2]);
                            int v3 = max(0, x3 - a[i][3]);
                            int v4 = max(0, x4 - a[i][4]);
                            int v5 = max(0, x5 - a[i][5]);
                            f[x1][x2][x3][x4][x5] = min(f[x1][x2][x3][x4][x5], f[v1][v2][v3][v4][v5] + c[i]);
                        }
                    }
                }
            }
        }
    }
    if (f[p[1]][p[2]][p[3]][p[4]][p[5]] == INF) f[p[1]][p[2]][p[3]][p[4]][p[5]] = -1LL;
    printf("%lld\n", f[p[1]][p[2]][p[3]][p[4]][p[5]]);

    return 0;
}