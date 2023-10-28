#include <cstdio>
#include <algorithm>

using namespace std;

int t, a, b;

void solve() {
    scanf("%d%d", &a, &b);
    if (a > b) swap(a, b);
    a *= 2;
    a = max(a, b);
    a *= a;
    printf("%d\n", a);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}