#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10;
int n, p, m;
int a[N];
struct Node {
    int l, r;
    LL sum, add, mul = 1LL;
} tr[N * 4];

void push_up(int u) {
    tr[u].sum = (tr[u << 1].sum + tr[u << 1 | 1].sum) % p;
}

void apply(Node& u, LL mul, LL add) {
    u.add = (u.add * mul % p + add) % p;
    u.mul = u.mul * mul % p;
    u.sum = (u.sum * mul % p + (u.r - u.l + 1) * add % p) % p;
}

void push_down(int u) {
    if (tr[u].add == 0LL && tr[u].mul == 1LL) return;
    apply(tr[u << 1], tr[u].mul, tr[u].add);
    apply(tr[u << 1 | 1], tr[u].mul, tr[u].add);
    tr[u].add = 0LL, tr[u].mul = 1LL;
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

// [l, r] * mul + add
void modify(int u, int l, int r, int mul, int add) {
    if (tr[u].l >= l && tr[u].r <= r) {
        apply(tr[u], mul, add);
    } else {
        push_down(u);
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= l) modify(u << 1, l, r, mul, add);
        if (m + 1 <= r) modify(u << 1 | 1, l, r, mul, add);
        push_up(u);
    }
}

LL query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;
    push_down(u);
    int m = tr[u].l + tr[u].r >> 1;
    LL res = 0LL;
    if (m >= l) res = (res + query(u << 1, l, r)) % p;
    if (m + 1 <= r) res = (res + query(u << 1 | 1, l, r)) % p;
    return res;
}

int main() {
    scanf("%d%d", &n, &p);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    build(1, 1, n);
    scanf("%d", &m);
    while (m--) {
        int op, l, r;
        scanf("%d%d%d", &op, &l, &r);
        int mul = 1, add = 0;
        if (op == 3) printf("%lld\n", query(1, l, r));
        else {
            if (op == 1) scanf("%d", &mul);
            else if (op == 2) scanf("%d", &add);
            modify(1, l, r, mul, add);
        }
    }

    return 0;
}