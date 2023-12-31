#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 110, C = 2e5 + 10;
int n, cnt, s1, s2;
int v[N], w[N], diff;
LL f[C + 1];

int main() {
    scanf("%d", &n);
    while (n--) {
        int x, y, z;
        scanf("%d%d%d", &x, &y, &z);
        if (x > y) {
            s1 += z;
            continue;
        }
        s2 += z;
        v[++cnt] = (y - x) / 2 + 1;
        w[cnt] = z * 2;
    }
    if (s1 > s2) {
        puts("0");
        return 0;
    }
    memset(f, 0x3f, sizeof(f));
    f[0] = 0LL;
    for (int i = 1; i <= cnt; ++i) {
        for (int j = C; j >= w[i]; --j) {
            f[j] = min(f[j], f[j - w[i]] + v[i]);
        }
    }
    diff = s2 - s1;
    LL ans = 1e18;
    for (int i = diff; i <= C; ++i) {
        ans = min(ans, f[i]);
    }
    printf("%lld\n", ans);

    return 0;
}