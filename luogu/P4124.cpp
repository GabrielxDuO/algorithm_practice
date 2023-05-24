#include <iostream>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 15;
LL l, r;
int len, digits[N];
LL f[N][N][N][2][2][2];

LL dfs(int pos, int prev, int before_prev, bool lim, bool has_four, bool has_eight, bool cont) {
    if (pos < 0) return cont;
    if (!lim && ~f[pos][prev][before_prev][has_four][has_eight][cont])
        return f[pos][prev][before_prev][has_four][has_eight][cont];
    LL res = 0L;
    int down = pos == len - 1 ? 1 : 0, up = lim ? digits[pos] : 9;
    for (int d = 0; d <= up; ++d) {
        if (has_four && d == 8 || has_eight && d == 4) continue;
        res += dfs(pos - 1, d, prev, lim && d == digits[pos], has_four || d == 4,
            has_eight || d == 8, cont || (d == prev && prev == before_prev));
    }
    return lim ? res : f[pos][prev][before_prev][has_four][has_eight][cont] = res;
}

LL count(LL n) {
    for (len = 0; n; n /= 10) digits[len++] = n % 10;
    memset(f, -1L, sizeof(f));
    return dfs(len - 1, 10, 10, true, false, false, false);
}

int main() {
    scanf("%lld%lld", &l, &r);
    LL ans = 0L;
    if (l == 1e10) ++ans, ++l;
    ans += count(r) - count(l - 1);
    printf("%lld\n", ans);

    return 0;
}