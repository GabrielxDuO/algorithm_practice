#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 3e4 + 10;
int w, n, a[N];

int main() {
    scanf("%d%d", &w, &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    int ans = 0;
    for (int i = 0, j = n - 1; i <= j; --j) {
        if (a[i] + a[j] <= w) ++i;
        ++ans;
    }
    printf("%d\n", ans);

    return 0;
}