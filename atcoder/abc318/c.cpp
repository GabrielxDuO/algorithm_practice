#include <cstdio>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int n, d, p;
int a[N];

int main() {
    scanf("%d%d%d", &n, &d, &p);
    LL tot = 0LL;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
        tot += a[i];
    }
    sort(a, a + n);
    int i = n - 1;
    while (i >= 0) {
        LL sum = 0LL;
        for (int j = 0; i >= 0 && j < d; --i, ++j) sum += a[i];
        if (p < sum) tot = tot - sum + p;
    }
    printf("%lld\n", tot);

    return 0;
}