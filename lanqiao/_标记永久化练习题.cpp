#include <cstdio>
#include <cmath>

using namespace std;

const int N = 1e5 + 10, K = log2(1e9) + 1;
struct Sgt {
    struct Node {
        int l, r, sum, lazy;
    } tr[N * 4];

    void push_up(int u) {
        tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
    }

    void push_down(int u) {
        int& lazy = tr[u].lazy;
        if (lazy == 0) return;
        Node& ln = tr[u << 1], & rn = tr[u << 1 | 1];
        ln.lazy |= lazy, ln.sum = ln.r - ln.l + 1;
        rn.lazy |= lazy, rn.sum = rn.r - rn.l + 1;
        lazy = 0;
    }

    void build(int u, int l, int r) {
        tr[u].l = l, tr[u].r = r;
        if (l == r) return;
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }

    void modify(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].sum = tr[u].r - tr[u].l + 1;
            tr[u].lazy |= 1;
        } else {
            push_down(u);
            int m = tr[u].l + tr[u].r >> 1;
            if (m >= l) modify(u << 1, l, r);
            if (m + 1 <= r) modify(u << 1 | 1, l, r);
            push_up(u);
        }
    }

    int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;
        push_down(u);
        int m = tr[u].l + tr[u].r >> 1;
        int res = 0;
        if (m >= l) res += query(u << 1, l, r);
        if (m + 1 <= r) res += query(u << 1 | 1, l, r);
        return res;
    }
} sgts[K];
int n, q;
int type;

int main() {
    scanf("%d%d", &n, &q);
    for (int i = 0; i < K; ++i) sgts[i].build(1, 1, n);
    while (q--) {
        scanf("%d", &type);
        if (type == 1) {
            int l, r, x; scanf("%d%d%d", &l, &r, &x);
            for (int k = 0; k < K; ++k) {
                int i = (x >> k) & 1;
                if (i) sgts[k].modify(1, l, r);
            }
        } else {
            int u; scanf("%d", &u);
            int ans = 0;
            for (int k = 0; k < K; ++k) {
                ans += sgts[k].query(1, u, u) << k;
            }
            printf("%d\n", ans);
        }
    }

    return 0;
}