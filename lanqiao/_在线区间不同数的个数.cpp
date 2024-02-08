#include <cstdio>
#include <cmath>

using namespace std;

const int N = 1e5 + 10, K = log2(N) + 2;
int n, q, a[N];
struct Node {
    int ln, rn, cnt;
} tr[N * 2 * K];
int roots[N], lasts[N], tot;

void insert(int& u, int p, int l, int r, int x, int y) {
    u = ++tot, tr[u] = tr[p], tr[u].cnt += y;
    if (l == r) return;
    int m = l + r >> 1;
    if (x <= m) insert(tr[u].ln, tr[p].ln, l, m, x, y);
    else insert(tr[u].rn, tr[p].rn, m + 1, r, x, y);
}

int query(int u, int l, int r, int x) {
    if (l == r) return tr[u].cnt;
    int m = l + r >> 1;
    if (x <= m) return query(tr[u].ln, l, m, x) + tr[tr[u].rn].cnt;
    else return query(tr[u].rn, m + 1, r, x);
}

int main() {
    scanf("%d%d", &n, &q);
    for (int i = 1, rt; i <= n; ++i) {
        scanf("%d", &a[i]);
        if (!lasts[a[i]]) insert(roots[i], roots[i - 1], 1, n, i, 1);
        else {
            insert(rt, roots[i - 1], 1, n, lasts[a[i]], -1);
            insert(roots[i], rt, 1, n, i, 1);
        }
        lasts[a[i]] = i;
    }
    int ans = 0;
    while (q--) {
        int l, r; scanf("%d%d", &l, &r);
        l = (l + ans) % n + 1, r = (r + ans) % n + 1;
        if (l > r) swap(l, r);
        ans = query(roots[r], 1, n, l);
        printf("%d\n", ans);
    }

    return 0;
}