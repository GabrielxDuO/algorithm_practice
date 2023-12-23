#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

LL n;
int m;

int main() {
    scanf("%lld%d", &n, &m);
    LL l = n, t = n, r = 0, b = 0;
    while (m--) {
        LL x, y;
        scanf("%lld%lld", &x, &y);
        l = min(l, x);
        t = min(t, y);
        r = max(r, x);
        b = max(b, y);
    }
    printf("%lld\n", max(r - l + 1, b - t + 1));

    return 0;
}