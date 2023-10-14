#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, k;
int a[N];

bool check(int m) {
    int cnt = 0;
    int l = 0, r = 0;
    for (; r < n; ++r) {
        if (a[r] - a[l] > m) {
            ++cnt;
            l = r;
        }
    }
    if (l < n) ++cnt;
    return cnt <= k;
}

int main() {
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    int l = 0, r = a[n - 1] - a[0];
    while (l < r) {
        int m = l + (r - l >> 1);
        if (check(m)) r = m;
        else l = m + 1;
    }
    printf("%d\n", l);

    return 0;
}