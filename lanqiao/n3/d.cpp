#include <cstdio>

using namespace std;

typedef long long LL;

int t;
int a, b, c;

bool check(LL m) {
    LL cnt = a / c;
    if (a % c == 0) --cnt;
    return b - (cnt + 1) * m <= 0;
}

void solve() {
    scanf("%d%d%d", &a, &b, &c);
    if (c >= a) {
        printf("%d\n", b);
        return;
    }
    LL l = 1, r = b;
    while (l < r) {
        LL m = l + r >> 1;
        if (check(m)) r = m;
        else l = m + 1;
    }
    printf("%lld\n", l);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}