#include <iostream>
#include <limits>

using namespace std;

const int N = 110, DIRS[][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int n, m;
bool g[N][N];
int cnt;

void dfs(int x, int y) {
    g[x][y] = false;
    for (auto& DIR: DIRS) {
        int nx = x + DIR[0], ny = y + DIR[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && g[nx][ny]) dfs(nx, ny);
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; ++i) {
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        for (int j = 0; j < m; ++j) {
            char x;
            scanf("%c", &x);
            if (x != '0') g[i][j] = true;
        }
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (g[i][j]) {
                dfs(i, j);
                ++cnt;
            }
        }
    }
    printf("%d\n", cnt);

    return 0;
}