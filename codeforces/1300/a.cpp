#include <cstdio>

using namespace std;

int t, n;

void solve() {
    scanf("%d", &n);
    int sum = 0, zero_cnt = 0;
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        if (x == 0) ++zero_cnt;
        sum += x;
    }
    int ans = zero_cnt;
    sum += zero_cnt;
    if (sum == 0) ++ans;
    printf("%d\n", ans);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}