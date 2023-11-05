#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 5010, MOD = 998244353;
int q, k;
char op[2];
int x;
LL dp[N];

int main() {
    scanf("%d%d", &q, &k);
    dp[0] = 1LL;
    for (int i = 0; i < q; ++i) {
        scanf("%s%d", op, &x);
        if (op[0] == '+') {
            for (int j = k; j >= x; --j) {
                dp[j] = (dp[j] + dp[j - x]) % MOD;
            }
        } else {
            for (int j = x; j <= k; ++j) {
                dp[j] = ((dp[j] - dp[j - x]) % MOD + MOD) % MOD;
            }
        }
        printf("%lld\n", dp[k]);
    }

    return 0;
}