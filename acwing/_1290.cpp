#include <cstdio>

using namespace std;

typedef long long LL;

const int MOD = 100003;
LL m, n;

LL kasumi(LL base, LL exp, LL mod) {
    LL res = 1LL;
    while (exp) {
        if (exp & 1) res = (res * base) % mod;
        base = (base * base) % mod;
        exp >>= 1;
    }
    return res;
}

int main() {
    scanf("%lld%lld", &m, &n);
    LL tot = kasumi(m, n, MOD);
    LL nope = m * kasumi(m - 1, n - 1, MOD) % MOD;
    printf("%lld\n", ((tot - nope) % MOD + MOD) % MOD);

    return 0;
}