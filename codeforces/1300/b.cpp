#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 2e5 + 10;
int t, n;
int a[N];

void solve() {
    scanf("%d", &n);
    for (int i = 1; i <= n * 2; ++i) scanf("%d", &a[i]);
    sort(a + 1, a + n * 2 + 1);
    printf("%d\n", a[n + 1] - a[n]);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}