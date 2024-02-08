#include <cstdio>

using namespace std;

typedef unsigned long long ULL;

const int N = 1e6 + 10, P = 13331;
int n, q;
ULL p[N];
char s[N];
struct Node {
    int l, r;
    ULL lh, rh;

    friend Node operator+(const Node& lhs, const Node& rhs) {
        Node u;
        u.l = lhs.l, u.r = rhs.r;
        u.lh = lhs.lh + rhs.lh * p[lhs.r - lhs.l + 1];
        u.rh = rhs.rh + lhs.rh * p[rhs.r - rhs.l + 1];
        return u;
    }
} tr[N * 4];
int op;

void push_up(int u) {
    tr[u] = tr[u << 1] + tr[u << 1 | 1];
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) tr[u].lh = tr[u].rh = s[l];
    else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int i, char x) {
    if (tr[u].l == i && tr[u].r == i) tr[u].lh = tr[u].rh = x;
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= i) modify(u << 1, i, x);
        else modify(u << 1 | 1, i, x);
        push_up(u);
    } 
}

Node query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u];
    int m = tr[u].l + tr[u].r >> 1;
    if (r <= m) return query(u << 1, l, r);
    if (l >= m + 1) return query(u << 1 | 1, l, r);
    return query(u << 1, l, r) + query(u << 1 | 1, l, r);
}

int main() {
    scanf("%d%d%s", &n, &q, s + 1);
    p[0] = 1ULL;
    for (int i = 1; i <= n; ++i) p[i] = p[i - 1] * P;
    build(1, 1, n);
    while (q--) {
        scanf("%d", &op);
        if (op == 1) {
            int x;
            char c[2]; scanf("%d%s", &x, c);
            modify(1, x, c[0]);
        } else {
            int l, r; scanf("%d%d", &l, &r);
            Node u = query(1, l, r);
            puts(u.lh == u.rh ? "Yes" : "No");
        }
    }

    return 0;
}