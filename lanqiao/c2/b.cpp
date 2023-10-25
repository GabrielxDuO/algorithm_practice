#include <cstdio>
#include <algorithm>

using namespace std;

int t, n, m;

void solve() {
    scanf("%d%d", &n, &m);
    if (n > m) swap(n, m);
    if (n < 2 || m < 3) {
        puts("No");
        return;
    }
    puts(n * m % 6 == 0 ? "Yes" : "No");
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}