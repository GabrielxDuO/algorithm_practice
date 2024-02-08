#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, a[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    sort(a + 1, a + n + 1, [](const int& x, const int& y) { return x > y; });
    LL s1 = 0, s2 = 0;
    for (int i = 1; i <= n / 2; ++i) {
        if (i & 1) s1 += a[i * 2 - 1], s2 += a[i * 2];
        else s1 += a[i * 2], s2 += a[i * 2 - 1];
    }
    printf("%lld %lld\n", s1, s2);

    return 0;
}