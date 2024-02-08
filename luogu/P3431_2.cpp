#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

typedef long long LL;

const int K = 1e5 + 10;
int n, m, k;
struct Pos {
    int x, y, w;

    bool operator<(const Pos& o) const {
        return x != o.x ? x < o.x : y < o.y;
    }
} pos[K];
int alls[K];
struct Node {
    int l, r;
    LL mx;
} tr[K * 4];

void push_up(int u) {
    tr[u].mx = max(tr[u << 1].mx, tr[u << 1 | 1].mx);
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) return;
    int m = l + r >> 1;
    build(u << 1, l, m);
    build(u << 1 | 1, m + 1, r);
    push_up(u);
}

void modify(int u, int i, int x) {
    if (tr[u].l == i && tr[u].r == i) tr[u].mx = x;
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= i) modify(u << 1, i, x);
        else modify(u << 1 | 1, i, x);
        push_up(u);
    }
}

LL query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u]. r <= r) return tr[u].mx;
    int m = tr[u].l + tr[u].r >> 1;
    LL res = 0LL;
    if (m >= l) res = query(u << 1, l, r);
    if (m + 1 <= r) res = max(res, query(u << 1 | 1, l, r));
    return res;
}

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 1; i <= k; ++i) {
        scanf("%d%d%d", &pos[i].x, &pos[i].y, &pos[i].w);
        alls[i] = pos[i].y;
    }
    build(1, 1, k);
    sort(pos + 1, pos + k + 1);
    sort(alls + 1, alls + k + 1);
    int len = unique(alls + 1, alls + k + 1) - (alls + 1);
    LL ans = 0LL;
    for (int i = 1; i <= k; ++i) {
        pos[i].y = lower_bound(alls + 1, alls + len + 1, pos[i].y) - alls;
        LL u = query(1, 1, pos[i].y) + pos[i].w;
        ans = max(ans, u);
        modify(1, pos[i].y, u);
    }
    printf("%lld\n", ans);

    return 0;
}