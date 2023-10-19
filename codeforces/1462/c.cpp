#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

int t, n;

void solve() {
    scanf("%d", &n);
    if (n > 45) {
        puts("-1");
        return;
    }
    int ans = 0;
    for (int d = 9; d >= 1; --d) {
        if (d <= n) {
            ans = ans * 10 + d;
            n -= d;
        }
    }
    while (ans) {
        printf("%d", ans % 10);
        ans /= 10;
    }
    putchar('\n');
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}