#include <cstdio>

using namespace std;

typedef long long LL;

int n;

int cd(int n) {
    int cnt = 1;
    for (int x = 2; x <= n / x; ++x) {
        if (n % x == 0) {
            int s = 0;
            while (n % x == 0) {
                ++s;
                n /= x;
            }
            cnt *= s + 1;
        }
    }
    if (n > 1) cnt *= 2;
    return cnt;
}

int main() {
    scanf("%d", &n);
    LL ans = 0LL;
    for (int x = 1; x <= n; ++x) ans += cd(x);
    printf("%lld\n", ans);

    return 0;
}