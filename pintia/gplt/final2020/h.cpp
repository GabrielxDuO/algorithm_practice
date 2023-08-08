#include <cstdio>

using namespace std;

int g[4][4];
bool known[10];
int sx, sy;
int price[] = {10000, 36, 720, 360, 80, 252, 108, 72, 54, 180, 72, 180, 119, 36, 306, 1080, 144, 1800, 3600};

int main() {
    for (int i = 1; i <= 3; ++i) {
        for (int j = 1; j <= 3; ++j) {
            scanf("%d", &g[i][j]);
            if (!g[i][j]) sx = i, sy = j;
            known[g[i][j]] = true;
        }
    }
    for (int x = 1; x <= 9; ++x) {
        if (!known[x]) {
            g[sx][sy] = x;
            break;
        }
    }
    for (int i = 0; i < 3; ++i) {
        int x, y; scanf("%d%d", &x, &y);
        printf("%d\n", g[x][y]);
    }
    int sel; scanf("%d", &sel);
    int sum = 0;
    if (sel <= 3) {
        for (int i = 1; i <= 3; ++i) sum += g[sel][i];
    } else if (sel <= 6) {
        for (int i = 1; i <= 3; ++i) sum += g[i][sel - 3];
    } else if (sel == 7) {
        for (int i = 1; i <= 3; ++i) sum += g[i][i];
    } else if (sel == 8) {
        for (int i = 1; i <= 3; ++i) sum += g[i][4 - i];
    }
    printf("%d\n", price[sum - 6]);

    return 0;
}