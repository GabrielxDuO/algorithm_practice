#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 10;
struct Poly {
    char shape[4][4];
    int l = 4, r = 0, t = 4, b = 0;
} polys[3][4];
int g[N][N], bak[N][N];
int tot;

void rotate(Poly& dest, const Poly& src) {
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
            dest.shape[j][3 - i] = src.shape[i][j];
            if (src.shape[i][j] == '#') {
                dest.l = min(dest.l, 3 - i), dest.r = max(dest.r, 3 - i);
                dest.t = min(dest.t, j), dest.b = max(dest.b, j);
            }
        }
    }
}

void alter(const Poly& p, int x, int y, int d) {
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
            int nx = x + i, ny = y + j;
            if (p.shape[i][j] == '#') g[nx][ny] += d;
        }
    }
}

bool dfs(int u) {
    if (u == 3) {
        for (int i = 3; i <= 6; ++i) {
            for (int j = 3; j <= 6; ++j) {
                if (g[i][j] != 1) return false;
            }
        }
        return true;
    }
    for (int i = 0; i < 4; ++i) {
        const Poly& p = polys[u][i];
        for (int x = 0; x < 7; ++x) {
            for (int y = 0; y < 7; ++y) {
                if (x + p.t < 3 || x + p.b > 6 || y + p.l < 3 || y + p.r > 6) continue;
                alter(p, x, y, 1);
                if (dfs(u + 1)) return true;
                alter(p, x, y, -1);
            }
        }
    }
    return false;
}

int main() {
    for (int i = 0; i < 3; ++i) {
        Poly& p = polys[i][0];
        for (int j = 0; j < 4; ++j) {
            for (int k = 0; k < 4; ++k) {
                p.shape[j][k] = getchar();
                if (p.shape[j][k] == '#') {
                    ++tot;
                    p.l = min(p.l, k), p.r = max(p.r, k);
                    p.t = min(p.t, j), p.b = max(p.b, j);
                }
            }
            getchar();
        }
        for (int j = 1; j < 4; ++j) rotate(polys[i][j], polys[i][j - 1]);
    }
    if (tot != 16) {
        puts("No");
        return 0;
    }
    puts(dfs(0) ? "Yes" : "No");

    return 0;
}