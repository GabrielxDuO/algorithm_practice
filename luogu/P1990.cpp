#include <iostream>

using namespace std;

const int N = 1e6 + 10, MOD = 1e4;
int n;
int f[N], g[N];

int main() {
    scanf("%d", &n);
    f[0] = f[1] = g[1] = 1;
    for (int i = 2; i <= n; ++i) {
        f[i] = ((f[i - 1] + f[i - 2]) % MOD + 2 * g[i - 2] % MOD) % MOD;
        g[i] = (g[i - 1] + f[i - 1]) % MOD;
    }
    printf("%d\n", f[n]);

    return 0;
}