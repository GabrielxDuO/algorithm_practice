#include <cstdio>
#include <algorithm>
#include <cstring>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 2e5 + 10;
int t, n;
PII segs[N];
int alls[N * 2];
int tr[2][N * 2];

int lowbit(int x) {
    return x & -x;
}

void add(int u, int i, int x) {
    for (; i <= n * 2; i += lowbit(i)) tr[u][i] += x;
}

int qry(int u, int i) {
    int res = 0;
    for (; i > 0; i -= lowbit(i)) res += tr[u][i];
    return res;
}

int uniq() {
    int slow = 1;
    for (int fast = 1; fast <= n * 2; ++fast) {
        if (alls[slow] != alls[fast]) alls[++slow] = alls[fast];
    }
    return slow;
}

int get(int l, int r, const int& x) {
    while (l < r) {
        int m = l + r >> 1;
        if (alls[m] >= x) r = m;
        else l = m + 1;
    }
    return l;
}

void solve() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
        int l, r;
        scanf("%d%d", &l, &r);
        segs[i] = {l, r};
        alls[i] = l, alls[i + n] = r;
    }
    sort(alls + 1, alls + n * 2 + 1);
    int sz = uniq();
    sort(segs + 1, segs + n + 1);
    for (int i = 1; i <= sz; ++i) tr[0][i] = tr[1][i] = 0;
    for (int i = 1; i <= n; ++i) {
        segs[i].fi = get(1, sz, segs[i].fi);
        segs[i].se = get(1, sz, segs[i].se);
    }
    for (int i = 1; i <= n; ++i) {
        add(1, segs[i].fi, 1);
    }
    int mx = 0;
    for (int i = 1; i <= n; ++i) {
        const int& l = segs[i].fi, & r = segs[i].se;
        int lc = qry(0, sz) - qry(0, l - 1);
        int rc = qry(1, r) - qry(1, l - 1);
        int cnt = lc + rc;
        mx = max(mx, cnt);
        add(1, l, -1);
        add(0, r, 1);
    }
    printf("%d\n", n - mx);
}

int main() {
    scanf("%d", &t);
    while (t--) solve();

    return 0;
}