#include <iostream>

using namespace std;

typedef long long LL;

const int N = 5010, MOD = 1e9 + 7;
int n, cnts[N];

LL C(int a, int b) {
    LL nume = 1L, deno = 1L;
    for (int i = a, j = 1; j <= b; --i, ++j) {
        nume *= i;
        deno *= j;
    }
    return (nume / deno) % MOD;
}

int main() {
    scanf("%d", &n);
    if (n < 4) {
        puts("0");
        return 0;
    }
    int mx = 0;
    while (n-- > 0) {
        int x;
        scanf("%d", &x);
        ++cnts[x];
        mx = max(mx, x);
    }
    LL ans = 0L;
    for (int a = 1; a <= mx; ++a) {
        if (cnts[a] < 2) continue;
        LL c1 = C(cnts[a], 2);
        for (int b = 1; b <= a - b; ++b) {
            int c = a - b;
            if (b == c) {
                if (cnts[b] < 2) continue;
                LL c2 = C(cnts[b], 2);
                ans = (ans + c1 * c2 % MOD) % MOD;
            } else if (cnts[b] >= 1 && cnts[c] >= 1) {
                ans = (ans + c1 * cnts[b] % MOD * cnts[c] % MOD) % MOD;
            }
        }
    }
    printf("%lld\n", ans);

    return 0;
}