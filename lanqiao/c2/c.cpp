#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, k;
int d[N];

int main() {
    scanf("%d%d", &n, &k);
    int prev = 0;
    for (int i = 0; i < n; ++i) {
        int x; scanf("%d", &x);
        if (i > 0) d[i] = x - prev;
        prev = x;
    }
    sort(d + 1, d + n);
    int ans = 0;
    for (int i = 1; i <= n - k; ++i) ans += d[i];
    printf("%d\n", ans);

    return 0;
}