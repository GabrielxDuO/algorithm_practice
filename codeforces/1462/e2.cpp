#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10, MOD = 1e9 + 7;
int t, n, m, k;
int a[N];
int fac[N], ifac[N];

LL kasumi(LL base, LL exp, LL mod) {
    LL res = 1LL;
    while (exp) {
        if (exp & 1) res = res * base % mod;
        base = base * base % mod;
        exp >>= 1;
    }
    return res;
}

int right_bound(int l, int r, int x) {
    while (l < r) {
        int mid = l + r + 1 >> 1;
        if (a[mid] <= x) l = mid;
        else r = mid - 1;
    }
    return r;
}

LL C(int n, int m) {
    if (n < m) return 0;
    if (n == m) return 1;
    return 1LL * fac[n] * ifac[m] % MOD * ifac[n - m] % MOD;
}

void solve() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    LL ans = 0LL;
    for (int i = 0; i < n; ++i) {
        int cnt = right_bound(0, n - 1, a[i] + k) - i;
        ans = (ans + C(cnt, m - 1)) % MOD;
    }
    printf("%lld\n", ans);
}

int main() {
    scanf("%d", &t);
    fac[0] = ifac[0] = 1;
    for (int i = 1; i <= 2e5; ++i) {
        fac[i] = (int) (1LL * i * fac[i - 1] % MOD);
        ifac[i] = (int) kasumi(fac[i], MOD - 2, MOD);
    }
    while (t--) solve();

    return 0;
}