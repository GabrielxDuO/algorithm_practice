#include <iostream>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 55, MOD = 10000007;
LL n;
int len, digits[N];
LL f[N][N];
LL cnts[N];

LL qmi(LL base, LL exp, LL mod) {
    LL res = 1L;
    while (exp) {
        if (exp & 1) res = res * base % mod;
        base = base * base % mod;
        exp >>= 1;
    }
    return res;
}

LL dfs(int pos, int cnt, bool lim, int x) {
    if (pos < 0) return cnt == x;
    if (!lim && ~f[pos][cnt]) return f[pos][cnt];
    LL res = 0L;
    int up = lim ? digits[pos] : 1;
    for (int d = 0; d <= up; ++d) {
        res += dfs(pos - 1, cnt + d, lim && d == digits[pos], x);
    }
    return lim ? res : f[pos][cnt] = res;
}

int main() {
    scanf("%lld", &n);
    for (len = 0; n; n >>= 1) digits[len++] = n & 1;
    for (int x = 1; x <= 50; ++x) {
        memset(f, -1, sizeof(f));
        cnts[x] = dfs(len - 1, 0, true, x);
    }
    LL ans = 1L;
    for (int x = 1; x <= 50; ++x) {
        ans = ans * qmi(x, cnts[x], MOD) % MOD;
    }
    printf("%lld\n", ans);

    return 0;
}