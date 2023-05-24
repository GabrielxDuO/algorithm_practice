#include <iostream>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 30;
const int DIRS[][2] = {{0, 0}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
int tx, ty, hx, hy;
bool g[N][N];
LL f[N][N];

LL dfs(int x, int y) {
    if (x < 0 || x > tx || y < 0 || y > ty || g[x][y]) return 0;
    if (~f[x][y]) return f[x][y];
    LL cnt = dfs(x + 1, y) + dfs(x, y + 1);
    return f[x][y] = cnt;
}

int main() {
    scanf("%d%d%d%d", &tx, &ty, &hx, &hy);
    for (auto& DIR : DIRS) {
        int nx = hx + DIR[0], ny = hy + DIR[1];
        if (nx < 0 || nx > tx || ny < 0 || ny > tx) continue;
        g[nx][ny] = true;
    }
    memset(f, -1, sizeof(f));
    f[tx][ty] = 1;
    printf("%lld\n", dfs(0, 0));

    return 0;
}