#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

int t;

LL sub(LL n, LL u, LL k) {
    if (k < 0 || k >= 64 || u > n) return 0LL;
    LL l = u, r = u;
    bool l_of = false, r_of = false;
    for (int i = 0; i < k; ++i) {
        l = l * 2;
        r = r * 2 + 1;
        if (l > n) l_of = true, l = n;
        if (r > n) r_of = true, r = n;
    }
    if (l_of && r_of) return 0LL;
    return r - l + 1;
}

int main() {
    scanf("%d", &t);
    LL n, x, k;
    while (t--) {
        scanf("%lld%lld%lld", &n, &x, &k);
        LL ans = 0;
        if (k > 0) ans += sub(n, x, k);
        while (x > 1 && k > 0) {
            --k;
            ans += sub(n, x ^ 1, k - 1);
            x /= 2;
        }
        if (x > 0 && k == 0) ++ans;
        printf("%lld\n", ans);
    }

    return 0;
}