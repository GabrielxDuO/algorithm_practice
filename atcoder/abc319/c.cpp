#include <cstdio>
#include <cstring>

using namespace std;

int g[3][3];
int chosen[9];
bool used[9];
int cnt = 0, tot = 0;
bool opened[3][3];

bool check() {
    for (int i = 0; i < 3; ++i) {
        if (opened[i][0] && opened[i][1] && !opened[i][2] && g[i][0] == g[i][1] ||
            opened[i][1] && opened[i][2] && !opened[i][0] && g[i][1] == g[i][2] ||
            opened[i][0] && opened[i][2] && !opened[i][1] && g[i][0] == g[i][2]) return true;
        if (opened[0][i] && opened[1][i] && !opened[2][i] && g[0][i] == g[1][i] ||
            opened[1][i] && opened[2][i] && !opened[0][i] && g[1][i] == g[2][i] ||
            opened[0][i] && opened[2][i] && !opened[1][i] && g[0][i] == g[2][i]) return true;
    }
    if (opened[0][0] && opened[1][1] && !opened[2][2] && g[0][0] == g[1][1] ||
        opened[2][2] && opened[1][1] && !opened[0][0] && g[2][2] == g[1][1] ||
        opened[2][2] && opened[0][0] && !opened[1][1] && g[2][2] == g[0][0] ||
        opened[0][2] && opened[1][1] && !opened[2][0] && g[0][2] == g[1][1] ||
        opened[2][0] && opened[1][1] && !opened[0][2] && g[2][0] == g[1][1] ||
        opened[2][0] && opened[0][2] && !opened[1][1] && g[2][0] == g[0][2]) return true;
    return false;
}

void dfs(int u) {
    if (u == 9) {
        ++tot;
        memset(opened, false, sizeof(opened));
        for (const int& x : chosen) {
            opened[x / 3][x % 3] = true;
            if (check()) {
                ++cnt;
                return;
            }
        }
        return;
    }
    for (int x = 0; x < 9; ++x) {
        if (!used[x]) {
            chosen[u] = x;
            used[x] = true;
            dfs(u + 1);
            used[x] = false;
        }
    }
}

int main() {
    for (int i = 0; i < 3; ++i)
        for (int j = 0; j < 3; ++j) scanf("%d", &g[i][j]);
    dfs(0);
    printf("%lf\n", (tot - cnt) * 1.0 / tot);

    return 0;
}