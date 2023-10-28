#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1010;
int t, n;
int a[N];

void solve() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
    sort(a, a + n);
    int mn = 2e9;
    for (int i = 1; i < n; ++i) mn = min(mn, a[i] - a[i - 1]);
    printf("%d\n", mn);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}