#include <cstdio>
#include <queue>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 2010, DIRS[][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int ro[128], co[128];
int n, m;
char g[N][N];
int sx, sy, dx, dy;

int _ = [] {
    ro['^'] = co['<'] = -1;
    ro['v'] = co['>'] = 1;
    return 0;
}();

bool process() {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            const char& u = g[i][j];
            if (u == 'S') { sx = i, sy = j; continue; } 
            if (u == 'G') { dx = i, dy = j; continue; }
            if (u == '.' || u == '#' || u == '!') continue;
            for (int r = i + ro[u], c = j + co[u];
                r >= 0 && r < n && c >= 0 && c < m;
                r += ro[u], c += co[u]) {
                if (g[r][c] == 'S' || g[r][c] == 'G') return false;
                if (g[r][c] == '!') continue;
                if (g[r][c] != '.') break;
                g[r][c] = '!';
            }
        }
    }
    return true;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%s", g[i]);
    if (!process()) {
        puts("-1");
        return 0;
    }
    g[sx][sy] = g[dx][dy] = '.';
    queue<PII> que;
    int step = 0;
    que.push({sx, sy});
    while (!que.empty()) {
        int sz = que.size();
        while (sz--) {
            PII u = que.front(); que.pop();
            int x = u.fi, y = u.se;
            if (x == dx && y == dy) {
                printf("%d\n", step);
                return 0;
            }
            for (const auto& DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] != '.') continue;
                g[nx][ny] = 'o';
                que.push({nx, ny});
            }
        }
        ++step;
    }
    puts("-1");

    return 0;
}