#include <iostream>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, k;
int a[N];

bool check(LL m) {
    int cnt = 1;
    LL curr = 0L;
    for (int i = 0; i < n; ++i) {
        LL x = (LL) a[i] * a[i];
        if (curr + x > m) {
            if (++cnt > k) return false;
            curr = x;
        } else curr += x;
    }
    return cnt <= k;
}

int main() {
    scanf("%d%d", &n, &k);
    LL l = 0, r = 0;
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
        l = max(l, (LL) a[i] * a[i]);
        r += (LL) a[i] * a[i];
    }
    while (l < r) {
        LL m = l + (r - l >> 1);
        if (check(m)) r = m;
        else l = m + 1;
    }
    printf("%lld\n", l);

    return 0;
}