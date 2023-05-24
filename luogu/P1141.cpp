#include <iostream>
#include <limits>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

typedef pair<int, int> PII;

const int N = 1010, DIRS[][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int n, m;
bool g[N][N], vis[N][N];
int mp[N][N];
queue<PII> que;

int bfs(int x, int y) {
    que.push({x, y});
    vis[x][y] = true;
    int step = 1;
    vector<PII> seen;
    while (!que.empty()) {
        auto pr = que.front();
        que.pop();
        int x = pr.first, y = pr.second;
        bool curr = g[x][y];
        for (auto& DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx > 0 && nx <= n && ny > 0 && ny <= n && !vis[nx][ny] && g[nx][ny] != curr) {
                que.push({nx, ny});
                vis[nx][ny] = true;
                ++step;
                seen.push_back({nx, ny});
            }
        }
    }
    for (auto& pr : seen) mp[pr.first][pr.second] = step;
    mp[x][y] = step;
    return step;
}

int main() {
    // freopen("in", "r", stdin);
    // freopen("out", "w", stdout);
    memset(mp, -1, sizeof(mp));
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) {
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        for (int j = 1; j <= n; ++j) {
            char c;
            scanf("%c", &c);
            g[i][j] = c - '0';
        }
    }
    while (m--) {
        int x, y;
        scanf("%d%d", &x, &y);
        if (!~mp[x][y]) bfs(x, y);
        printf("%d\n", mp[x][y]);
    }

    return 0;
}