#include <cstdio>

using namespace std;

const int N = 1e6 + 10;
int primes[N], cnt;
bool np[N + 1];
int n;

void sieve(int n) {
    for (int x = 2; x <= n; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] <= n / x; ++i) {
            np[primes[i] * x] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int count(int n, int d) {
    int cnt = 0;
    while (n) cnt += n /= d;
    return cnt;
}

int main() {
    scanf("%d", &n);
    sieve(n);
    for (int i = 0; i < cnt; ++i) {
        int cnt = count(n, primes[i]);
        if (cnt) printf("%d %d\n", primes[i], cnt);
    }

    return 0;
}