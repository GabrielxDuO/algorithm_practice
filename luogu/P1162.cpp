#include <iostream>
#include <queue>

using namespace std;

typedef pair<int, int> PII;

const int N = 40, DIRS[][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int n, g[N][N];

int main() {
    scanf("%d", &n);
    bool found;
    int x, y;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            scanf("%d", &g[i][j]);
            if (!found && g[i][j]) {
                x = i, y = j;
                found = true;
            }
        }
    }
    while (g[++x][++y]);
    queue<PII> que;
    que.push({x, y});
    g[x][y] = 2;
    while (!que.empty()) {
        auto pr = que.front();
        que.pop();
        x = pr.first, y = pr.second;
        for (auto& DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !g[nx][ny]) {
                g[nx][ny] = 2;
                que.push({nx, ny});
            }
        }
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) printf("%d ", g[i][j]);
        puts("");
    }

    return 0;
}