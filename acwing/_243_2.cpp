#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e6 + 10;
int n, m;
int a[N];
struct Node {
    int l, r;
    LL sum;
    int lazy;
} tr[N * 4];
char op[2];

void push_up(int u) {
    tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
}

void push_down(int u) {
    int& lazy = tr[u].lazy;
    if (lazy == 0) return;
    Node& ln = tr[u << 1], & rn = tr[u << 1 | 1];
    ln.lazy += lazy, ln.sum += 1LL * (ln.r - ln.l + 1) * lazy;
    rn.lazy += lazy, rn.sum += 1LL * (rn.r - rn.l + 1) * lazy;
    lazy = 0;
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) tr[u].sum = a[l];
    else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int l, int r, int x) {
    if (tr[u].l >= l && tr[u].r <= r) {
        tr[u].sum += 1LL * (tr[u].r - tr[u].l + 1) * x;
        tr[u].lazy += x;
    } else {
        push_down(u);
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= l) modify(u << 1, l, r, x);
        if (m + 1 <= r) modify(u << 1 | 1, l, r, x);
        push_up(u);
    }
}

LL query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;
    push_down(u);
    int m = tr[u].l + tr[u].r >> 1;
    LL res = 0LL;
    if (m >= l) res += query(u << 1, l, r);
    if (m + 1 <= r) res += query(u << 1 | 1, l, r);
    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    build(1, 1, n);
    while (m--) {
        int l, r;
        scanf("%s%d%d", op, &l, &r);
        if (op[0] == 'C') {
            int d; scanf("%d", &d);
            modify(1, l, r, d);
        } else printf("%lld\n", query(1, l, r));
    }

    return 0;
}