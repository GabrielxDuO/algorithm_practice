#include <iostream>

using namespace std;

const int N = 60;
int n, m;
char g[N][N];

int main() {
    scanf("%d%d\n", &n, &m);
    for (int i = 0; i < n; ++i) cin.getline(g[i], N);
    int mn = n * m;
    for (int w = 1; w <= n - 2; ++w) {
        for (int b = 1; b + w <= n - 1; ++b) {
            int r = n - w - b;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (i < w && g[i][j] != 'W') ++cnt;
                    else if (i >= w && i < w + b && g[i][j] != 'B') ++cnt;
                    else if (i >= w + b && g[i][j] != 'R') ++cnt;
                }
            }
            mn = min(mn, cnt);
        }
    }
    printf("%d\n", mn);

    return 0;
}