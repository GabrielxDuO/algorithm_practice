#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

int t;

LL count(LL n, LL u, LL k) {
    if (k < 0 || k >= 64) return 0LL;
    LL l = u, r = u;
    while (k-- > 0) {
        l = l << 1;
        r = r << 1 | 1;
        if (l > n) return 0LL;
    }
    return min(r, n) - l + 1;
}

int main() {
    scanf("%d", &t);
    LL n, x, k;
    while (t--) {
        scanf("%lld%lld%lld", &n, &x, &k);
        LL ans = count(n, x, k);
        while (x >> 1 && k--) {
            ans += count(n, x >> 1, k) - count(n, x, k - 1);
            x >>= 1;
        }
        printf("%lld\n", ans);
    }

    return 0;
}