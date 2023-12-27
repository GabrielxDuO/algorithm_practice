#include <cstdio>

using namespace std;

typedef long long LL;

const int A = 1e6 + 10;
const LL N = 1e16;
LL lcms[A];
int t;
int a;
LL n;

LL gcd(LL a, LL b) {
    return b == 0 ? a : gcd(b, a % b);
}

LL lcm(LL a, LL b) {
    return a / gcd(a, b) * b;
}

void solve() {
    scanf("%d%lld", &a, &n);
    if (lcms[a - 1] == 0) puts("0");
    else if (lcms[a] == 0) printf("%lld\n", n / lcms[a - 1]);
    else printf("%lld\n", n / lcms[a - 1] - (n / lcms[a]));
}

int main() {
    lcms[1] = 1LL;
    for (int i = 2; i < A; ++i) {
        lcms[i] = lcm(lcms[i - 1], i);
        if (lcms[i] > N) break;
    }
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}