#include <iostream>
#include <cstring>

using namespace std;

const int N = 30;
int n, m;
bool d[N][N], vis[N];

int check() {
    for (int i = 0; i < n; ++i) {
        if (d[i][i]) return 1;
    }
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if (!d[i][j] && !d[j][i]) return 0;
        }
    }
    return 2;
}

int get_min() {
    for (int i = 0; i < n; ++i) {
        if (vis[i]) continue;
        for (int j = 0; j < n; ++j) {
            if (!vis[j] && d[i][j]) goto out;
        }
        vis[i] = true;
        return i;
        out:;
    }
}

int main() {
    while (~scanf("%d%d", &n, &m) && (n || m)) {
        memset(d, false, sizeof(d));
        int res = 0, t = 0;
        for (int i = 0; i < m; ++i) {
            char a, b;
            scanf("\n%c<%c", &a, &b);
            if (res) continue;
            ++t;
            a -= 'A', b -= 'A';
            d[b][a] = true; // a < b ==> b -> a
            for (int x = 0; x < n; ++x) {
                d[x][a] |= d[x][b]; // x > b ==> x > b > a
                d[b][x] |= d[a][x]; // x < a ==> x < b < a
                for (int y = 0; y < n; ++y) {
                    d[x][y] |= d[x][b] && d[a][y]; // x > b & a > y ==> x > b > a > y
                }
            }
            res = check();
        }
        if (res == 0) puts("Sorted sequence cannot be determined.");
        else if (res == 1) {
            printf("Inconsistency found after %d relations.\n", t);
        } else {
            printf("Sorted sequence determined after %d relations: ", t);
            memset(vis, false, sizeof(vis));
            for (int i = 0; i < n; ++i) printf("%c", get_min() + 'A');
            puts(".");
        }
        out:;
    }

    return 0;
}