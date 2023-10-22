#include <cstdio>
#include <cmath>

using namespace std;

const int N = 2e4;
int n;
bool np[N];
int primes[N], cnt;

void sieve(int n) {
    np[1] = false;
    for (int x = 2; x <= n; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] <= n / x; ++i) {
            np[x * primes[i]] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int main() {
    scanf("%d", &n);
    sieve(n);
    for (int i = 0; i < cnt; ++i) {
        for (int j = i; j < cnt; ++j) {
            int c = n - primes[i] - primes[j];
            if (c <= 0) continue;
            if (!np[c]) {
                printf("%d %d %d\n", primes[i], primes[j], c);
                return 0;
            }
        }
    }

    return 0;
}