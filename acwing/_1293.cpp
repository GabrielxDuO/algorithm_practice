#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n;
int primes[N], cnt;
bool np[N];

void sieve(int n) {
    for (int x = 2; x < n; ++x) {
        if (!np[x]) primes[cnt++] = x;
        for (int i = 0; primes[i] <= n / x; ++i) {
            np[primes[i] * x] = true;
            if (x % primes[i] == 0) break;
        }
    }
}

int main() {
    scanf("%d", &n);
    if (n <= 2) {
        puts("1");
        printf("1 ");
        if (n == 2) printf("1 ");
    } else {
        sieve(n + 1);
        puts("2");
        for (int x = 2; x <= n + 1; ++x) printf("%d ", np[x] + 1);
    }

    return 0;
}