#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n;
LL s[N];
int primes[N], cnt;
bool np[N];

void sieve(int n) {
    np[1] = true;
    for (int x = 2; x <= n; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] * x <= n; ++i) {
            np[primes[i] * x] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        scanf("%lld", &s[i]);
        s[i] += s[i - 1];
    }
    sieve(n);
    LL mx = -2e18;
    for (int i = 0; i < cnt; ++i) {
        const int& len = primes[i];
        for (int j = len; j <= n; ++j) {
            mx = max(mx, s[j] - s[j - len]);
        }
    }
    printf("%lld\n", mx);

    return 0;
}