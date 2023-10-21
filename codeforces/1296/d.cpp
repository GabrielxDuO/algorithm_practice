#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 2e5 + 10;
int n, a, b, k;
int h[N];

int main() {
    scanf("%d%d%d%d", &n, &a, &b, &k);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &h[i]);
        h[i] %= a + b;
        if (h[i] == 0) h[i] += a + b;
    }
    sort(h, h + n);
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        h[i] -= a;
        int cnt = (h[i] + a - 1) / a;
        if (cnt <= k) {
            ++ans;
            k -= cnt;
        } else break;
    }
    printf("%d\n", ans);

    return 0;
}