#include <cstdio>
#include <algorithm>

using namespace std;

int t, n, k;

void solve() {
    scanf("%d%d", &n, &k);
    if (k >= n) {
        puts("1");
        return;
    }
    int mn = n;
    for (int x = 1; x <= n / x; ++x) {
        if (n % x == 0) {
            int y = n / x;
            if (y <= k) mn = min(mn, x);
            if (x <= k) mn = min(mn, y);
        }
    }
    printf("%d\n", mn);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}