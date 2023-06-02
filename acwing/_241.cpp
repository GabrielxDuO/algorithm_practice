#include <cstdio>
#include <cstring>

#define lowbit(x) (x & (-x))

using namespace std;

typedef long long LL;

const int N = 2e5 + 10;
int n, a[N];
int tr[N];
int gtr[N], lwr[N];

void add(int i, int x) {
    for (; i <= n; i += lowbit(i)) tr[i] += x;
}

int query(int i) {
    int res = 0;
    for (; i > 0; i -= lowbit(i)) res += tr[i];
    return res;
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    for (int i = 1; i <= n; ++i) {
        gtr[i] = query(n) - query(a[i]);
        lwr[i] = query(a[i] - 1);
        add(a[i], 1);
    }
    LL ans1 = 0L, ans2 = 0L;
    memset(tr, 0, sizeof(tr));
    for (int i = n; i > 0; --i) {
        ans1 += 1L * gtr[i] * (query(n) - query(a[i]));
        ans2 += 1L * lwr[i] * query(a[i] - 1);
        add(a[i], 1);
    }
    printf("%lld %lld\n", ans1, ans2);

    return 0;
}