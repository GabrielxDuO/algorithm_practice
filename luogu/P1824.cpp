#include <iostream>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10, INF = 0x3f3f3f3f;
int n, c, lmt;
int a[N];

bool check(int m) {
    int cnt = 0, prev = a[0];
    for (int i = 1; i < n; ++i) {
        if (a[i] - prev < m) {
            if (++cnt > lmt) return false;
        } else prev = a[i];
    }
    return cnt <= lmt;
}


int main() {
    scanf("%d%d", &n, &c);
    lmt = n - c;
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    int l = INF, r = a[n - 1] - a[0];
    for (int i = 1; i < n; ++i) l = min(l, a[i] - a[i - 1]);
    while (l < r) {
        int m = l + r + 1 >> 1;
        if (check(m)) l = m;
        else r = m - 1;
    }
    printf("%d\n", l);

    return 0;
}