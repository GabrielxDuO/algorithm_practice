#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10, M = 25;
int n, m, q;
int a[N], w[M];
LL f[N];

int main() {
    scanf("%d%d%d", &n, &m, &q);
    int prev = 0;
    for (int i = 0; i < q; ++i) {
        int x; scanf("%d", &x);
        a[i] = x - prev - 1;
        prev = x;
    }
    a[q] = n - prev;
    for (int i = 0; i < m; ++i) {
        int k, s;
        scanf("%d%d", &k, &s);
        w[k] = max(w[k], s);
    }
    LL ans = 0LL;
    for (int k = 0; k <= q; ++k) {
        int c = a[k];
        memset(f, 0LL, sizeof(f));
        for (int i = 0; i <= 20; ++i) {
            int v = 1 << i;
            for (int j = v; j <= c; ++j) {
                f[j] = max(f[j], f[j - v] + w[i]);
            }
        }
        ans += f[c];
    }
    printf("%lld\n", ans);

    return 0;
}