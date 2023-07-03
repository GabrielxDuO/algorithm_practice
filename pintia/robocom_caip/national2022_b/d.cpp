#include <cstdio>
#include <cstring>

using namespace std;

const int N = 110, DIRS[][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
int n, m, len;
char g[N][N];
char s[25];
bool used[N][N];

bool dfs(int x, int y, int u) {
    if (u == len - 1) return true;
    for (auto& DIR : DIRS) {
        int nx = x + DIR[0], ny = y + DIR[1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || used[nx][ny] || g[nx][ny] != s[u + 1]) continue;
        used[nx][ny] = true;
        if (dfs(nx, ny, u + 1)) return true;
        used[nx][ny] = false;
    }
    return false;
}

int main() {
    scanf("%d%d\n", &n, &m);
    for (int i = 0; i < n; ++i) scanf("%s", g[i]);
    scanf("%s", s);
    len = strlen(s);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (g[i][j] == s[0]) {
                used[i][j] = true;
                if (dfs(i, j, 0)) {
                    for (int x = 0; x < n; ++x) {
                        for (int y = 0; y < m; ++y) {
                            if (!used[x][y]) g[x][y] = '.';
                        }
                    }
                    for (int x = 0; x < n; ++x) printf("%s\n", g[x]);
                    return 0;
                }
                used[i][j] = false;
            }
        }
    }

    return 0;
}