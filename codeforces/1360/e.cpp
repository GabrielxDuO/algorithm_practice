#include <cstdio>

using namespace std;

const int N = 55;
int t, n;
char g[N][N];

void solve() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        getchar();
        for (int j = 0; j < n; ++j) g[i][j] = getchar();
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (g[i][j] == '1' && i + 1 < n && g[i + 1][j] == '0' &&
                    j + 1 < n && g[i][j + 1] == '0') {
                puts("NO");
                return;
            }
        }
    }
    puts("YES");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}