#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int t, n;
int a[N];

int right_bound(int l, int r, int x) {
    while (l < r) {
        int m = l + r + 1 >> 1;
        if (a[m] <= x) l = m;
        else r = m - 1;
    }
    return r;
}

void solve() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    LL ans = 0;
    for (int i = 0; i < n; ++i) {
        int cnt = right_bound(i + 1, n - 1, a[i] + 2) - i;
        ans += 1LL * cnt * (cnt - 1) / 2;
    }
    printf("%lld\n", ans);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}