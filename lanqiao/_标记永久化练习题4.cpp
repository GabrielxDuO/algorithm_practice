#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

const int N = 1e5 + 10;
int n;
struct Pos {
    int x, y, w;

    bool operator<(const Pos& o) const {
        return x != o.x ? x < o.x : y < o.y;
    }
} pos[N];
struct Node {
    int l, r, mx;
} tr[N * 4];

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

int query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u].mx;
    int m = tr[u].l + tr[u].r >> 1;
    int res = -2e9;
    if (m >= l) res = query(u << 1, l, r);
    if (m + 1 <= r) res = max(res, query(u << 1 | 1, l, r));
    return res;
}

int main() {
    scanf("%d", &n);
    bool has_dest = false;
    for (int i = 1; i <= n; ++i) {
        scanf("%d%d%d", &pos[i].x, &pos[i].y, &pos[i].w);
        if (pos[i].x == 1e5 && pos[i].y == 1e5) has_dest = true;
    }
    if (!has_dest) {
        // 在终点加个权值为0的哨兵用于算答案
        pos[++n] = {(int) 1e5, (int) 1e5, 0};
    }
    build(1, 1, 1e5);
    sort(pos + 1, pos + n + 1);
    for (int i = 1; i <= n; ++i) {
        int u = query(1, 1, pos[i].y) + pos[i].w;
        if (pos[i].x == 1e5 && pos[i].y == 1e5) {
            printf("%d\n", u);
            return 0;
        }
        modify(1, pos[i].y, u);
    }

    return 0;
}