#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int n, m, p;
int a[N], b[N];
LL s[N];

int main() {
    scanf("%d%d%d", &n, &m, &p);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    for (int i = 1; i <= m; ++i) scanf("%d", &b[i]);
    sort(b + 1, b + m + 1);
    for (int i = 1; i <= m; ++i) s[i] = s[i - 1] + b[i];
    puts("");
    LL ans = 0LL;
    for (int i = 1; i <= n; ++i) {
        int l = 1, r = m;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (a[i] + b[m] < p) l = m;
            else r = m - 1;
        }
        if (a[i] + b[r] >= p) --r;
        ans += s[r] + 1LL * r * a[i] + 1LL * (m - r) * p;
    }
    printf("%lld\n", ans);

    return 0;
}