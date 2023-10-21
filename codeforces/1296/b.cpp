#include <cstdio>

using namespace std;

int t, n;

void solve() {
    scanf("%d", &n);
    int ans = 0;
    while (n / 10) {
        ans += n / 10 * 10;
        n = n / 10 + n % 10;
    }
    ans += n;
    printf("%d\n", ans);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}