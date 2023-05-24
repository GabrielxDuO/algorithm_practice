#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int n = 21, m = 1 << n;
LL dp[m][n];
bool g[n][n];

int gcd(int a, int b) {
    return b ? gcd(b, a % b) : a;
}

int main() {
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (gcd(i, j) == 1) g[i - 1][j - 1] = g[j - 1][i - 1] = true;
        }
    }
    dp[1][0] = 1;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if ((i >> j & 1) == 0) continue;
                int prev = i - (1 << j);
                for (int k = 0; k < n; ++k) {
                    if (g[j][k] && (prev >> k & 1)) dp[i][j] += dp[prev][k];
                }
            
        }
    }
    LL cnt = 0;
    for (int i = 0; i < n; ++i) {
        cnt += dp[m - 1][i];
    }
    printf("%lld", cnt);

    return 0;
}