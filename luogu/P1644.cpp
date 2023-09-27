#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 20, DIRS[][2] = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
int n, m;
LL f[N][N];

LL dfs(int x, int y) {
    if (f[x][y]) return f[x][y];
    if (x == n && y == m) return f[x][y] = 1;
    for (const auto& DIR : DIRS) {
        int nx = x + DIR[0], ny = y + DIR[1];
        if (nx < 0 || nx > n || ny < 0 || ny > m) continue;
        f[x][y] += dfs(nx, ny);
    }
    return f[x][y];
}

int main() {
    scanf("%d%d", &n, &m);
    printf("%lld\n", dfs(0, 0));

    return 0;
}