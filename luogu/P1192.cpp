#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10, MOD = 100003;
int n, k;
LL f[N];

int main() {
    scanf("%d%d", &n, &k);
    f[0] = 1LL;
    for (int i = 1; i <= n; ++i) {
        for (int j = i - 1; j >= 0 && i - j <= k; --j) {
            f[i] = (f[i] + f[j]) % MOD;
        }
    }
    printf("%lld\n", f[n]);

    return 0;
}