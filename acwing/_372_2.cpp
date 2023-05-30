#include <iostream>
#include <cstring>

#define fst first
#define sec second

using namespace std;

typedef pair<int, int> PII;

const int N = 110, DIRS[][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int n, t;
bool g[N][N];
bool vis[N][N];
PII match[N][N];

bool find(int x, int y) {
    for (auto& DIR : DIRS) {
        int nx = x + DIR[0], ny = y + DIR[1];
        if (nx <= 0 || nx > n || ny <= 0 || ny > n || g[nx][ny] || vis[nx][ny]) continue;
        vis[nx][ny] = true;
        if (!match[nx][ny].fst || find(match[nx][ny].fst, match[nx][ny].sec)) {
            match[nx][ny] = {x, y};
            return true;
        }
    }
    return false;
}

int main() {
    scanf("%d%d", &n, &t);
    while (t--) {
        int x, y;
        scanf("%d%d", &x, &y);
        g[x][y] = true;
    }
    int ans = 0;
    for (int x = 1; x <= n; ++x) {
        for (int y = 1 + (x & 1); y <= n; y += 2) {
            if (g[x][y]) continue;
            memset(vis, false, sizeof(vis));
            if (find(x, y)) ++ans;
        }
    }
    printf("%d\n", ans);

    return 0;
}