#include <cstdio>
#include <cmath>

using namespace std;

const int N = 2e5 + 10, K = log2(1e9) + 1;
int n, m;
char a[N];
int op;
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
        ln.lazy ^= lazy, ln.sum = (ln.r - ln.l + 1) - ln.sum;
        rn.lazy ^= lazy, rn.sum = (rn.r - rn.l + 1) - rn.sum;
        lazy = 0;
    }

    void build(int u, int l, int r) {
        tr[u].l = l, tr[u].r = r;
        if (l == r) {
            tr[u].sum = a[l] - '0';
        } else {
            int m = l + r >> 1;
            build(u << 1, l, m);
            build(u << 1 | 1, m + 1, r);
            push_up(u);
        }
    }

    void modify(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].lazy ^= 1;
            tr[u].sum = (tr[u].r - tr[u].l + 1) - tr[u].sum;
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
} sgt;

int main() {
    scanf("%d%d%s", &n, &m, a + 1);
    sgt.build(1, 1, n);
    while (m--) {
        int l, r; scanf("%d%d%d", &op, &l, &r);
        if (op == 0) sgt.modify(1, l, r);
        else printf("%d\n", sgt.query(1, l, r));
    }

    return 0;
}