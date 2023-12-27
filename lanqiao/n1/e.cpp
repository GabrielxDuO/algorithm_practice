#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 5e3 + 10;
int n, a[N];
int f[N], g[N];

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    int mx = 0;
    for (int i = 1; i <= n; ++i) {
        f[i] = 1;
        for (int j = 1; j < i; ++j) {
            if (a[j] < a[i]) f[i] = max(f[i], f[j] + 1);
        }
        mx = max(mx, f[i]);
    }
    for (int i = n; i >= 1; --i) {
        g[i] = 1;
        for (int j = n; j > i; --j) {
            if (a[j] > a[i]) g[i] = max(g[i], g[j] + 1);
        }
    }
    // 把后面改大
    for (int i = 1; i < n; ++i) {
        /*if ( a[i + 1] < 1e100 )*/ mx = max(mx, f[i] + 1);
    }
    // 把前面改小
    for (int i = 2; i <= n; ++i) {
        if (a[i - 1] > 0) mx = max(mx, g[i] + 1);
    }
    // 改夹在中间的元素
    for (int l = 1; l <= n; ++l) {
        for (int r = l + 2; r <= n; ++r) {
            if (a[l] + 1 < a[r]) mx = max(mx, f[l] + g[r] + 1);
        }
    }
    printf("%d\n", mx);

    return 0;
}