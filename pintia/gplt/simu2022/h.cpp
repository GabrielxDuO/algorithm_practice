#include <cstdio>

using namespace std;

const int N = 1e6 + 10;
int primes[N], cnt;
bool np[N];
int m, n;

void sieve(int n) {
    np[1] = true;
    for (int x = 2; x <= n; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] <= n / x; ++i) {
            np[primes[i] * x] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int main() {
    scanf("%d%d", &m, &n);
    sieve(n * n);
    int ans = 0;
    for (int p = m; p + 2 <= n; ++p) {
        if (np[p]) continue;
        for (int q = p + 1; q + 1 <= n; ++q) {
            if (np[q]) continue;
            for (int r = q + 1; r <= n; ++r) {
                if (np[r]) continue;
                if (!np[p * q + r] && !np[q * r + p] && !np[r * p + q]) ++ans;
            }
        }
    }
    printf("%d\n", ans);

    return 0;
}