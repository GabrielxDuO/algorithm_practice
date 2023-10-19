#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 3010;
int t, n;
int a[N];

void solve() {
    scanf("%d", &n);
    int mx = 0, tot = 0;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
        mx = max(mx, a[i]);
        tot += a[i];
    }
    int avg = 0;
    for (int len = 1; len <= n; ++len) {
        avg += a[len - 1];
        if (avg < mx) continue;
        int sum = 0;
        for (int i = len; i < n; ++i) {
            if (sum + a[i] < avg) sum += a[i];
            else if (sum + a[i] == avg) sum = 0;
            else {
                sum = -1;
                break;
            }
        }
        if (sum == avg || sum == 0) {
            printf("%d\n", n - (tot / avg));
            return;
        }
    }
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}