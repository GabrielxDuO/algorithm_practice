#include <cstdio>
#include <cstring>

using namespace std;

typedef long long LL;

int t;
LL x, y;
char s[5];

void solve() {
    scanf("%lld%s%lld", &x, s, &y);
    if (s[0] != 'B') {
        x *= 1024;
        if (s[0] != 'K') x *= 1024;
    }
    printf("%lld\n", x / y);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}