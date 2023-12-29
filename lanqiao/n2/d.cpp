#include <cstdio>
#include <algorithm>

using namespace std;
typedef long long LL;

int A, B, S, T;

LL count(int up) {
    if (up < 0) return 0LL;
    LL res = 1LL * A * min(up + 1, B);
    for (int b = up + 2; b <= B; ++b) {
        res += 1LL * (A / b) * (up + 1) + min(A % b, up);
    }
    return res;
}

int main() {
    scanf("%d%d%d%d", &A, &B, &S, &T);
    printf("%lld\n", count(T) - count(S - 1));

    return 0;
}