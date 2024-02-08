#include <cstdio>

using namespace std;

typedef long long LL;

const int N = 1e6 + 10, MOD = 998244353;

int q, type;
LL cnts[N];
struct Node {
    int l, r;
    LL mul;
} tr[N * 4];

LL kasumi(LL a, LL b, LL m) {
    LL res = 1LL;
    while (b) {
        if (b & 1) res = res * a % m;
        a = a * a % m;
        b >>= 1;
    }
    return res;
}

void push_up(int u) {
    tr[u].mul = 1LL;
    if (tr[u << 1].mul) tr[u].mul = tr[u].mul * tr[u << 1].mul % MOD;
    if (tr[u << 1 | 1].mul) tr[u].mul = tr[u].mul * tr[u << 1 | 1].mul % MOD;
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) {
        tr[u].mul = 1LL;
    } else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int x) {
    if (tr[u].l == x && tr[u].r == x) {
        tr[u].mul = kasumi(x, cnts[x], MOD);
    } else {
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= x) modify(u << 1, x);
        if (m + 1 <= x) modify(u << 1 | 1, x);
        push_up(u);
    }
}

LL query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u].mul;
    LL res = 1LL;
    int m = tr[u].l + tr[u].r >> 1;
    if (m >= l) res = res * query(u << 1, l, r) % MOD;
    if (m + 1 <= r) res = res * query(u << 1 | 1, l, r) % MOD;
    return res;
}

int main() {
    scanf("%d", &q);
    build(1, 1, 1e6);
    while (q--) {
        scanf("%d", &type);
        if (type == 1) {
            int x, c; scanf("%d%d", &x, &c);
            if (!c) continue;
            cnts[x] += c;
            modify(1, x);
        } else {
            int c; scanf("%d", &c);
            printf("%lld\n", query(1, 1, c));
        }
    }

    return 0;
}