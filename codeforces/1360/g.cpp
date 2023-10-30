#include <cstdio>
#include <cstring>

using namespace std;

const int N = 55;
int t, n, m, a, b;
char g[N][N];

void solve() {
    scanf("%d%d%d%d", &n, &m, &a, &b);
    if (n * a != m * b) {
        puts("NO");
        return;
    }
    memset(g, '0', sizeof(g));
    int c = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < a; ++j, ++c) {
            if (c >= m) c = 0;
            g[i][c] = '1';
        }
    }
    puts("YES");
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) putchar(g[i][j]);
        putchar('\n');
    }
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}