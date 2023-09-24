#include <iostream>
#include <algorithm>

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int n, c, a[N];

int left_bound(int x) {
    int l = 0, r = n - 1;
    while (l < r) {
        int m = l + r >> 1;
        if (a[m] >= x) r = m;
        else l = m + 1;
    }
    return l;
}

int right_bound(int x) {
    int l = 0, r = n - 1;
    while (l < r) {
        int m = l + r + 1 >> 1;
        if (a[m] <= x) l = m;
        else r = m - 1;
    }
    return r;
}

int main() {
    scanf("%d%d", &n, &c);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    LL ans = 0;
    for (int i = 0; i < n; ++i) {
        int A = a[i] + c;
        int l = left_bound(A);
        if (a[l] != A) continue;
        int r = right_bound(A);
        ans += r - l + 1;
    }
    printf("%lld\n", ans);

    return 0;
}