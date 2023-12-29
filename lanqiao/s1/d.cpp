#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10, MOD = 998244353;
int a[N], b[N], c[N], d[N];

LL kasumi(LL base, LL exp, LL mod) {
    LL res = 1LL;
    while (exp) {
        if (exp & 1) res = res * base % mod;
        base = base * base % mod;
        exp >>= 1;
    }
    return res;
}

int main() {
    int n; scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    for (int i = 1; i <= n; ++i) scanf("%d", &b[i]);
    for (int i = 1; i <= n; ++i) scanf("%d", &c[i]);
    for (int i = 1; i <= n; ++i) scanf("%d", &d[i]);
    LL sr = 0LL, sc = 0LL;
    for (int i = 1; i <= n; ++i) {
        sr = (sr + a[i] * kasumi(b[i], MOD - 2, MOD) % MOD) % MOD;
        sc = (sc + c[i] * kasumi(d[i], MOD - 2, MOD) % MOD) % MOD;
    }
    LL ans = (sr * (((n - sc) % MOD + MOD) % MOD) % MOD +
        sc * (((n - sr) % MOD + MOD) % MOD) % MOD) % MOD;
    printf("%lld\n", ans);

    return 0;
}