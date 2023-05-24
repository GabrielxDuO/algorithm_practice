#include <iostream>
#include <queue>
#include <stack>

using namespace std;

const int N = 1010, M = N * N, DIRS[][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int n, g[N][N], prevs[M];

void bfs() {
    queue<int> que;
    que.push(0);
    g[0][0] = 1;
    while (!que.empty()) {
        int curr = que.front();
        que.pop();
        int x = curr / n, y = curr % n;
        if (x == n - 1 && y == n - 1) {
            stack<int> path;
            for (int i = (n - 1) * n + n - 1; i; i = prevs[i]) path.push(i);
            puts("0 0");
            while (!path.empty()) {
                int coord = path.top();
                path.pop();
                printf("%d %d\n", coord / n, coord % n);
            }
            return;
        }
        for (auto& DIR : DIRS) {
            int nx = x + DIR[0], ny = y + DIR[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !g[nx][ny]) {
                que.push(nx * n + ny);
                g[nx][ny] = 1;
                prevs[nx * n + ny] = curr;
            }
        }
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) scanf("%d", &g[i][j]);
    }
    bfs();

    return 0;
}