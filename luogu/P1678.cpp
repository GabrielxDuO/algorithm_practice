#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, m;
int a[N];

int main() {
    scanf("%d%d", &m, &n);
    for (int i = 0; i < m; ++i) scanf("%d", &a[i]);
    sort(a, a + m);
    LL ans = 0;
    for (int i = 0; i < n; ++i) {
        int x;
        scanf("%d", &x);
        int l = 0, r = m - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (a[m] >= x) r = m;
            else l = m + 1;
        }
        if (l == 0) ans += abs(a[l] - x);
        else ans += min(abs(a[l] - x), abs(x - a[l - 1]));
    }
    printf("%lld", ans);

    return 0;
}