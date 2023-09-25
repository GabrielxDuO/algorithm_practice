#include <cstdio>

using namespace std;

const int N = 10, DIRS[][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int n, m, t;
int sx, sy, fx, fy;
bool g[N][N];
int ans = 0;

void dfs(int x, int y) {
    if (x == fx && y == fy) {
        ++ans;
        return;
    }
    g[x][y] = true;
    for (auto& DIR : DIRS) {
        int nx = x + DIR[0], ny = y + DIR[1];
        if (nx <= 0 || nx > n || ny <= 0 || ny > m || g[nx][ny]) continue;
        dfs(nx, ny);
    }
    g[x][y] = false;
}

int main() {
    scanf("%d%d%d%d%d%d%d", &n, &m, &t, &sx, &sy, &fx, &fy);
    while (t--) {
        int x, y;
        scanf("%d%d", &x, &y);
        g[x][y] = true;
    }
    dfs(sx, sy);
    printf("%d\n", ans);

    return 0;
}