#include <cstdio>
#include <utility>
#include <algorithm>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 3e5 + 10;
int n;
PII a[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d%d", &a[i].fi, &a[i].se);
    sort(a, a + n, [](const PII& x, const PII & y) { return x.se < y.se; });
    if (a[n - 1].fi != a[n - 2].fi) {
        printf("%d\n", a[n - 1].se + a[n - 2].se);
        return 0;
    }
    int ans = a[n - 1].se + a[n - 2].se / 2;
    for (int i = n - 3; i >= 0; --i) {
        if (a[i].fi != a[n - 1].fi) {
            if (a[i].se + a[n - 1].se > ans) {
                printf("%d\n", a[i].se + a[n - 1].se);
                return 0;
            } else break;
        }
    }
    printf("%d\n", ans);

    return 0;
}