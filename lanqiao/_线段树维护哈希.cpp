#include <cstdio>

using namespace std;

typedef unsigned long long ULL;

const int N = 2e5 + 10, P = 13331;
ULL p[N];
char s[N];
int n, q;
struct Node {
    int l, r;
    ULL h;

    friend Node operator+(const Node& lhs, const Node& rhs) {
        Node u;
        u.l = lhs.l, u.r = rhs.r;
        u.h = lhs.h * p[rhs.r - rhs.l + 1] + rhs.h;
        return u;
    }
} tr[N * 4];

void push_up(int u) {
    tr[u] = tr[u << 1] + tr[u << 1 | 1];
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) tr[u].h = s[l];
    else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int i, char x) {
    if (tr[u].l == tr[u].r) tr[u].h = x;
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
    scanf("%d%s%d", &n, s + 1, &q);
    p[0] = 1ULL;
    for (int i = 1; i <= n; ++i) p[i] = p[i - 1] * P;
    build(1, 1, n);
    while (q--) {
        int op; scanf("%d", &op);
        if (op == 1) {
            int i; char c[2]; scanf("%d%s", &i, c);
            modify(1, i, c[0]);
        } else {
            int l1, r1, l2, r2; scanf("%d%d%d%d", &l1, &r1, &l2, &r2);
            puts(query(1, l1, r1).h == query(1, l2, r2).h ? "YES" : "NO");
        }
    }

    return 0;
}