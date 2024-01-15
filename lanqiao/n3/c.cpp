#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, k, a[N], b[N];

int main() {
    scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    for (int i = 1; i <= n; ++i) scanf("%d", &b[i]);
    LL ans = 4e18, sum = 0LL;
    int mn = 2e9;
    for (int i = 1; i <= n; ++i) {
        mn = min(mn, a[i] + b[i]);
        sum += a[i];
        ans = min(ans, sum + 1LL * max(k - i, 0) * mn);
    }
    printf("%lld\n", ans);

    return 0;
}