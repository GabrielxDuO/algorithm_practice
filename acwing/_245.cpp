#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 5e5 + 10;
int n, m, a[N];
struct Node {
    int l, r;
    // 最大连续子段和 最大前缀子段和 最大后缀子段和 区间和
    int mx, lmx, rmx, sum;
} tr[N * 4];

void pushup(Node& u, Node& l, Node& r) {
    u.sum = l.sum + r.sum;
    u.lmx = max(l.lmx, l.sum + r.lmx);
    u.rmx = max(r.rmx, r.sum + l.rmx);
    u.mx = max(max(l.mx, r.mx), l.rmx + r.lmx);
}

void pushup(int u) {
    pushup(tr[u], tr[u << 1], tr[u << 1 | 1]);
}

void build(int u, int l, int r) {
    if (l == r) tr[u] = {l, r, a[r], a[r], a[r], a[r]};
    else {
        tr[u] = {l, r};
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        pushup(u);
    }
}

void modify(int u, int i, int x) {
    if (tr[u].l == i && tr[u].r == i) tr[u] = {i, i, x, x, x, x};
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (i <= m) modify(u << 1, i, x);
        else modify(u << 1 | 1, i, x);
        pushup(u);
    }
}

Node query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u];
    int m = tr[u].l + tr[u].r >> 1;
    if (r <= m) return query(u << 1, l, r);
    else if (l >= m + 1) return query(u << 1 | 1, l, r);
    else {
        Node left = query(u << 1, l, r);
        Node right = query(u << 1 | 1, l, r);
        Node res;
        pushup(res, left, right);
        return res;
    }
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    build(1, 1, n);
    while (m--) {
        int k, x, y;
        scanf("%d%d%d", &k, &x, &y);
        if (k == 1) {
            if (x > y) swap(x, y);
            printf("%d\n", query(1, x, y).mx);
        } else modify(1, x, y);
    }

    return 0;
}