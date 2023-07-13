#include <cstdio>
#include <queue>
#include <vector>

using namespace std;

typedef pair<int, int> PII;

const int DIRS[][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
int n, m;
vector<vector<char>> g;
queue<PII> que;

bool bfs(int x, int y) {
    que.push({x, y});
    bool flag = g[x][y] > '1';
    g[x][y] = '0';
    while (!que.empty()) {
        auto u = que.front(); que.pop();
        x = u.first; y = u.second;
        for (auto& DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == '0') continue;
            if (g[nx][ny] > '1') flag = true;
            g[nx][ny] = '0';
            que.push({nx, ny});
        }
    }
    return flag;
}

int main() {
    scanf("%d%d", &n, &m);
    g.resize(n);
    for (int i = 0; i < n; ++i) {
        scanf("\n");
        g[i].resize(m);
        for (int j = 0; j < m; ++j) {
            scanf("%c", &g[i][j]);
        }
    }
    int cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (g[i][j] != '0') {
                ++cnt1;
                if (bfs(i, j)) ++cnt2;
            }
        }
    }
    printf("%d %d\n", cnt1, cnt2);

    return 0;
}