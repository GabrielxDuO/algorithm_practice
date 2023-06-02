#include <cstdio>

#define lowbit(x) (x & -x)

using namespace std;

const int N = 1e5 + 10;
int n, a[N];
int tr[N];
int ans[N];

void add(int i, int x) {
    for (; i <= n; i += lowbit(i)) tr[i] += x;
}

int qry(int i) {
    int res = 0;
    for (; i; i -= lowbit(i)) res += tr[i];
    return res;
}

int main() {
    scanf("%d", &n);
    for (int i = 2; i <= n; ++i) scanf("%d", &a[i]);
    for (int i = 1; i <= n; ++i) tr[i] = lowbit(i);
    for (int i = n; i >= 1; --i) {
        int k = a[i] + 1;
        int l = 1, r = n;
        while (l < r) {
            int m = l + r >> 1;
            if (qry(m) >= k) r = m;
            else l = m + 1;
        }
        ans[i] = l;
        add(l, -1);
    }
    for (int i = 1; i <= n; ++i) printf("%d\n", ans[i]);

    return 0;
}