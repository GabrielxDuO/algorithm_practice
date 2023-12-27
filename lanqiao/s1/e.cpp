#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10, MOD = 998244353;
int n;
int a[N];
int ones_ps[N][31], ones_ss[N][31];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    LL ans = 0LL;
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j < 31; ++j) {
            ones_ps[i][j] = ones_ps[i - 1][j];
            if ((a[i] >> j) & 1) ++ones_ps[i][j];
        }
    }
    for (int i = n; i >= 1; --i) {
        for (int j = 0; j < 31; ++j) {
            ones_ss[i][j] = ones_ss[i + 1][j];
            if ((a[i] >> j) & 1) ++ones_ss[i][j];
        }
    }
    for (int i = 2; i <= n - 2; ++i) {
        LL c = (1LL * (n - i) * (n - i - 1) / 2) % MOD;
        int j = n - i + 1;
        for (int k = 0, mask = 1; k < 31; ++k, mask <<= 1) {
            LL prev_ones = ones_ps[i - 1][k], prev_zeros = i - 1 - prev_ones;
            if ((a[i] >> k) & 1) ans = (ans + (mask * prev_zeros % MOD) * c % MOD) % MOD;
            else ans = (ans + (mask * prev_ones % MOD) * c % MOD) % MOD;

            LL suff_ones = ones_ss[j + 1][k], suff_zeros = n - j - suff_ones;
            if ((a[j] >> k) & 1) ans = (ans + (mask * suff_zeros % MOD) * c % MOD) % MOD;
            else ans = (ans + (mask * suff_ones % MOD) * c % MOD) % MOD;
        }
    }
    printf("%lld\n", ans);

    return 0;
}