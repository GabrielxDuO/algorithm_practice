#include <cstdio>
#include <algorithm>
#include <cstring>

using namespace std;

typedef long long LL;

const int N = 5e4, M = 1e6 + 10;
int primes1[N], cnt1, primes2[M], cnt2;
bool np1[N + 1], np2[M];

void sieve() {
    for (int x = 2; x <= N; ++x) {
        if (!np1[x]) primes1[cnt1++] = x;
        for (int i = 0; primes1[i] <= N / x; ++i) {
            np1[primes1[i] * x] = true;
            if (x % primes1[i] == 0) break;
        }
    }
}

void sieve(int l, int r) {
    memset(np2, false, sizeof(np2));
    for (int i = 0; i < cnt1; ++i) {
        LL p = primes1[i];
        for (LL x = max(2 * p, (l + p - 1) / p * p); x <= r; x += p) {
            np2[x - l] = true;
        }
    }
    cnt2 = 0;
    int n = r - l + 1;
    for (int i = 0; i < n; ++i) {
        if (!np2[i] && i + l >= 2) primes2[cnt2++] = i + l;
    }
}

int main() {
    sieve();
    int l, r;
    while (~scanf("%d%d", &l, &r)) {
        sieve(l, r);
        if (cnt2 < 2) puts("There are no adjacent primes.");
        else {
            int mn_gap = 0x3f3f3f3f, mx_gap = 0, mn_i, mx_i;
            for (int i = 0; i < cnt2 - 1; ++i) {
                int a = primes2[i], b = primes2[i + 1];
                if (b - a < mn_gap) {
                    mn_gap = b - a;
                    mn_i = i;
                }
                if (b - a > mx_gap) {
                    mx_gap = b - a;
                    mx_i = i;
                }
            }
            printf("%d,%d are closest, %d,%d are most distant.\n", 
                primes2[mn_i], primes2[mn_i + 1], primes2[mx_i], primes2[mx_i + 1]);
        }
    }

    return 0;
}