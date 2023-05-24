#include <iostream>
#include <queue>

using namespace std;

const int MAX_N = 25;
const int DIRECTIONS[][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
int n;
int rows[MAX_N], cols[MAX_N];
bool vis[MAX_N * MAX_N];
deque<int> path;

void dfs(int x, int y) {
    --rows[x], --cols[y];
    if (rows[x] < 0 || cols[y] < 0) return;
    int curr = x * n + y;
    vis[curr] = true;
    path.push_back(curr);
    if (curr == n * n - 1) {
        for (int i = 0; i < n; ++i) {
            if (rows[i] != 0 || cols[i] != 0) return;
        }
        while (!path.empty()) {
            printf("%d", path.front());
            path.pop_front();
            printf(path.empty() ? "\n" : " ");
        }
        exit(0);
    }
    for (auto d : DIRECTIONS) {
        int nx = x + d[0], ny = y + d[1];
        int next = nx * n + ny;
        if (nx < 0 || nx >= n || ny < 0 || ny >= n ||
            vis[next] || rows[nx] <= 0 || cols[ny] <= 0) continue;
        dfs(nx, ny);
        vis[next] = false;
        path.pop_back();
        ++rows[nx], ++cols[ny];
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &cols[i]);
    for (int i = 0; i < n; ++i) scanf("%d", &rows[i]);
    dfs(0, 0);

    return 0;
}