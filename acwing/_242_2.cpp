#include <cstdio>

using namespace std;

const int N = 1e5 + 10;
int n, m, b[N];
struct Node {
    int l, r, sum;
} tr[N * 4];

int pushup(int u) {
    tr[u].sum = tr[u << 1].sum + tr[u << 1 | 1].sum;
}

void build(int u, int l, int r) {
    if (l == r) tr[u] = {l, r, b[r]};
    else {
        tr[u] = {l, r, 0};
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        pushup(u);
    }
}

int query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;
    int m = tr[u].l + tr[u].r >> 1, res = 0;
    if (l <= m) res += query(u << 1, l, r);
    if (r >= m + 1) res += query(u << 1 | 1, l, r);
    return res;
}

void modify(int u, int i, int x) {
    if (tr[u].l == tr[u].r) tr[u].sum += x;
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (i <= m) modify(u << 1, i, x);
        else modify(u << 1 | 1, i, x);
        pushup(u);
    }
}

int main() {
    scanf("%d%d", &n, &m);
    int prev = 0;
    for (int i = 1; i <= n; ++i) {
        int x; scanf("%d", &x);
        b[i] = x - prev;
        prev = x;
    }
    build(1, 1, n);
    while (m--) {
        char op;
        scanf("\n%c", &op);
        if (op == 'C') {
            int l, r, d;
            scanf("%d%d%d", &l, &r, &d);
            modify(1, l, d), modify(1, r + 1, -d);
        } else {
            int x; scanf("%d", &x);
            printf("%d\n", query(1, 1, x));
        }
    }

    return 0;
}