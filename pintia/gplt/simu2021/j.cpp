#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, p;
int a[N];
long long sum;

int main() {
    scanf("%d%d", &n, &p);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    for (int i = 0; i < n - 1; ++i) {
        int mn = abs(p - a[i]), mx = p + a[i];
        sum += lower_bound(a + i + 1, a + n, mx) - upper_bound(a + i + 1, a + n, mn);
    }
    printf("%lld\n", sum);

    return 0;
}