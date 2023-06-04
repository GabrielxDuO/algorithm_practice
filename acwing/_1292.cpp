#include <cstdio>

using namespace std;

const int N = 1e6;
int primes[N], cnt;
bool np[N + 1];
int n;

void sieve() {
    for (int x = 2; x <= N; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] <= N / x; ++i) {
            np[primes[i] * x] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int main() {
    sieve();
    while (~scanf("%d", &n) && n) {
        for (int i = 0; i < cnt && primes[i] <= n - primes[i]; ++i) {
            if (!np[n - primes[i]]) {
                printf("%d = %d + %d\n", n, primes[i], n - primes[i]);
                goto out;
            }
        }
        puts("Goldbach's conjecture is wrong.");
        out:;
    }

    return 0;
}