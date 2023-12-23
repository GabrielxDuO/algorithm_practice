#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 100;
int primes[N + 10], cnt;
bool np[N + 10];

void sieve() {
    np[0] = np[1] = true;
    for (int x = 2; x <= N; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] * x <= N; ++i) {
            np[primes[i] * x] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int main() {
    int n; scanf("%d", &n);
    sieve();
    int ans = 0;
    while (n--) {
        int x; scanf("%d", &x);
        if (x < 2) {
            ans += 2 - x;
            continue;
        }
        if (!np[x]) continue;
        auto pos = lower_bound(primes, primes + cnt, x);
        int a = *pos, b = *(pos - 1);
        ans += min(abs(a - x), abs(b - x));
    }
    printf("%d\n", ans);

    return 0;
}