#include <cstdio>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 25;
const int DIRS[][2] = {{0, 0}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
int g[N][N];
LL f[N][N];
int n, m, mx, my, cnt = 0;

LL dfs(int x, int y) {
    if (x > n || y > m || g[x][y]) return 0LL;
    if (f[x][y]) return f[x][y];
    if (x == n && y == m) return f[x][y] = 1LL;
    return f[x][y] = dfs(x + 1, y) + dfs(x, y + 1);
}

int main() {
    scanf("%d%d%d%d", &n, &m, &mx, &my);
    for (auto DIR : DIRS) {
        int nx = mx + DIR[0], ny = my + DIR[1];
        if (nx >= 0 && nx <= n && ny >= 0 && ny <= m) g[nx][ny] = true;
    }
    printf("%lld\n", dfs(0, 0));

    return 0;
}