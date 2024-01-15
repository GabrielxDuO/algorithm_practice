#include <cstdio>
#include <utility>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n;
int a[N];
struct Node {
    int l, r, mx, mxi, mn, mni;
} tr[N * 4];
struct Exm {
    int mx = 0, mxi = 0, mn = 2e9, mni = 0;
};

void push_up(int u) {
    if (tr[u << 1].mx >= tr[u << 1 | 1].mx) {
        tr[u].mx = tr[u << 1].mx;
        tr[u].mxi = tr[u << 1].mxi;
    } else {
        tr[u].mx = tr[u << 1 | 1].mx;
        tr[u].mxi = tr[u << 1 | 1].mxi;
    }
    if (tr[u << 1].mn <= tr[u << 1 | 1].mn) {
        tr[u].mn = tr[u << 1].mn;
        tr[u].mni = tr[u << 1].mni;
    } else {
        tr[u].mn = tr[u << 1 | 1].mn;
        tr[u].mni = tr[u << 1 | 1].mni;
    }
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) {
        tr[u].mx = a[l];
        tr[u].mxi = l;
        tr[u].mn = a[l];
        tr[u].mni = l;
        return;
    }
    int m = l + r >> 1;
    build(u << 1, l, m);
    build(u << 1 | 1, m + 1, r);
    push_up(u);
}

Exm query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return {tr[u].mx, tr[u].mxi, tr[u].mn, tr[u].mni};
    int m = tr[u].l + tr[u].r >> 1;
    Exm res;
    if (m >= l) {
        Exm qry = query(u << 1, l, r);
        res = qry;
    }
    if (m + 1 <= r) {
        Exm qry = query(u << 1 | 1, l, r);
        if (qry.mx > res.mx) res.mx = qry.mx, res.mxi = qry.mxi;
        if (qry.mn < res.mn) res.mn = qry.mn, res.mni = qry.mni;
    }
    return res;
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

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    build(1, 1, n);
    Exm qry = query(1, 1, n);
    // printf("%d %d %d %d\n", qry.mx, qry.mxi, qry.mn, qry.mni);
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        Exm exi = query(1, 1, i);
        printf("%d %d %d %d\n", exi.mx, exi.mxi, exi.mn, exi.mni);
        if (exi.mxi == i) continue;
        Exm exj = query(1, exi.mxi, i);
        if (exj.mni == i) continue;
        ans = max(ans, (exi.mx + a[i]) / exj.mn);
    }
    // printf("%d\n", ans);

    return 0;
}