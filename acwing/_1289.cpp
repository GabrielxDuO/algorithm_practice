#include <cstdio>

using namespace std;

typedef long long LL;

const int MOD = 200907;
int t;

LL kasumi(LL base, LL exp, LL mod) {
    LL res = 1;
    while (exp) {
        if (exp & 1) res = (res * base) % mod;
        base = (base * base) % mod;
        exp >>= 1;
    }
    return res;
}

int main() {
    scanf("%d", &t);
    int a, b, c, k;
    while (t--) {
        scanf("%d%d%d%d", &a, &b, &c, &k);
        if (c - b == b - a) printf("%d\n", (int) ((a + 1L * (b - a) % MOD * (k - 1) % MOD) % MOD));
        else printf("%d\n", (int) (a * kasumi(b / a, k - 1, MOD) % MOD));
    }

    return 0;
}