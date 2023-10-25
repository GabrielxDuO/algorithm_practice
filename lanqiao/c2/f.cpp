#include <cstdio>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 15, K = 210, MOD = 998244353;
char sl[K], sr[K];
int len, digits[N];
LL f[N][K];

LL dfs(int pos, int sum, int prev, bool lim) {
    if (pos < 0) return prev > 0 && ((sum - prev) % prev == 0);
    if (~prev && !lim && f[pos][sum] != -1) return f[pos][sum];
    LL res = 0;
    int up = lim ? digits[pos] : 9;
    if (prev == -1) res = dfs(pos - 1, 0, -1, false);
    for (int d = !~prev; d <= up; ++d) {
        res = (res + dfs(pos - 1, sum + d, d, lim && d == digits[pos])) % MOD;
    }
    return lim || !~prev ? res : f[pos][sum] = res;
}

LL count(const char n[]) {
    len = strlen(n);
    for (int i = 0; i < len; ++i) digits[len - i - 1] = n[i] - '0';
    memset(f, -1, sizeof(f));
    return dfs(len - 1, 0, -1, true);
}

int main() {
    scanf("%s%s", sl, sr);
    // for (int i = strlen(sl) - 1; i >= 0; --i) {
    //     if (sl[i] == '0') sl[i] = '9';
    //     else {
    //         --sl[i];
    //         break;
    //     }
    // }
    // if (sl[0] == '0') {
    //     for (int i = 0; i < strlen(sl) - 1; ++i) sl[i] = sl[i + 1];
    //     sl[strlen(sl) - 1] = '\0';
    // }
    LL ans = (count(sr) - count(sl) + MOD) % MOD;
    int sum = 0;
    for (int i = 0; i < strlen(sl) - 1; ++i) sum += sl[i] - '0';
    if (sl[strlen(sl) - 1] != '0' && sum % (int) (sl[strlen(sl) - 1] - '0') == 0) ans = (ans + 1) % MOD;
    printf("%lld\n", ans);

    return 0;
}