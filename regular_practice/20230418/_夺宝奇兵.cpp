#include <iostream>

using namespace std;

const int N = 110;
int n;
int f[N][N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            int x; scanf("%d", &x);
            f[i][j] = max(f[i - 1][j], f[i - 1][j - 1]) + x;
        }
    }
    int mx = 0;
    for (int i = 1; i <= n; ++i) mx = max(mx, f[n][i]);
    printf("%d\n", mx);

    return 0;
}