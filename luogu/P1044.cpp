#include <iostream>

using namespace std;

typedef long long LL;

const int N = 20;
int n;
LL f[N][N];

LL dfs(int x, int y) {
    if (x < 0 || y < 0) return 0L;
    if (f[x][y]) return f[x][y];
    if (x == 0) return 1L;
    LL cnt = 0L;
    cnt += dfs(x - 1, y + 1);
    if (y > 0) cnt += dfs(x, y - 1);
    return f[x][y] = cnt;
}

int main() {
    scanf("%d", &n);
    f[0][n] = 1L;
    printf("%d\n", dfs(n, 0));

    return 0;
}