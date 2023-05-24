#include <iostream>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, x;
int a[N];

int main() {
    scanf("%d%d", &n, &x);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    LL ans = 0L;
    if (a[0] > x) {
        ans += a[0] - x;
        a[0] = x;
    }
    for (int i = 0; i < n - 1; ++i) {
        if (a[i] + a[i + 1] > x) {
            ans += a[i] + a[i + 1] - x;
            a[i + 1] = x - a[i];
        }
    }
    printf("%lld\n", ans);

    return 0;
}