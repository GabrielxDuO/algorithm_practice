#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 2e5 + 10;
int n;
int a[N], f[N], g[N];
int ans ;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    for (int i = 1; i <= n; ++i) {
        f[i] = 1;
        if (a[i] > a[i - 1]) f[i] = f[i - 1] + 1;
        ans = max(ans, f[i]);
    }
    for (int i = n; i >= 1; --i) {
        g[i] = 1;
        if (a[i] < a[i + 1]) g[i] = g[i + 1] + 1;
    }
    for (int i = 2; i < n; ++i) {
        if (a[i - 1] < a[i + 1]) ans = max(ans, f[i - 1] + g[i + 1]);
    }
    printf("%d\n", ans);

    return 0;
}