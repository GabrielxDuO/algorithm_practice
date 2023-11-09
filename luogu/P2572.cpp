#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n, m, a[N];
struct Node {
    int l, r;
    int mx[2], lmx[2], rmx[2], cnts[2];
    bool inv;
    int set = -1;

    void assign(int x) {
        mx[x] = lmx[x] = rmx[x] = cnts[x] = r - l + 1;
        mx[!x] = lmx[!x] = rmx[!x] = cnts[!x] = 0;
    }
} tr[N * 4];

void push_up(Node& un, Node& ln, Node& rn) {
    un.cnts[0] = ln.cnts[0] + rn.cnts[0];
    un.cnts[1] = ln.cnts[1] + rn.cnts[1];
    for (int i = 0; i <= 1; ++i) {
        un.lmx[i] = ln.cnts[1 - i] ? ln.lmx[i] : ln.cnts[i] + rn.lmx[i];
        un.rmx[i] = rn.cnts[1 - i] ? rn.rmx[i] : rn.cnts[i] + ln.rmx[i];
        un.mx[i] = max(max(ln.mx[i], rn.mx[i]), ln.rmx[i] + rn.lmx[i]);
    }
}

void push_up(int u) {
    push_up(tr[u], tr[u << 1], tr[u << 1 | 1]);
}

void swap(Node& un) {
    swap(un.cnts[0], un.cnts[1]);
    swap(un.mx[0], un.mx[1]);
    swap(un.lmx[0], un.lmx[1]);
    swap(un.rmx[0], un.rmx[1]);
}

void apply(Node& un, int type) {
    int len = un.r - un.l + 1;
    // 重要: 赋值和取反两个懒标记会互相影响
    if (type <= 1) {
        un.inv = false;
        un.set = type;
        un.assign(type);
    } else {
        un.inv ^= 1;
        swap(un);
    }
}

void push_down(int u) {
    Node& un = tr[u];
    if (~un.set) {
        apply(tr[u << 1], un.set);
        apply(tr[u << 1 | 1], un.set);
        un.set = -1;
    }
    if (un.inv) {
        apply(tr[u << 1], 2);
        apply(tr[u << 1 | 1], 2);
        un.inv = false;
    }
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) tr[u].assign(a[l]);
    else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int l, int r, int type) {
    if (tr[u].l >= l && tr[u].r <= r) apply(tr[u], type);
    else {
        push_down(u);
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= l) modify(u << 1, l, r, type);
        if (m + 1 <= r) modify(u << 1 | 1, l, r, type);
        push_up(u);
    }
}

Node query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u];
    push_down(u);
    int m = tr[u].l + tr[u].r >> 1;
    if (m >= r) return query(u << 1, l, r);
    if (m + 1 <= l) return query(u << 1 | 1, l, r);
    Node res;
    Node ln = query(u << 1, l, r), rn = query(u << 1 | 1, l, r);
    push_up(res, ln, rn);
    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    build(1, 1, n);
    while (m--) {
        int op, l, r;
        scanf("%d%d%d", &op, &l, &r);
        ++l, ++r;
        if (op <= 2) modify(1, l, r, op);
        else if (op == 3) printf("%d\n", query(1, l, r).cnts[1]);
        else printf("%d\n", query(1, l, r).mx[1]);
    }

    return 0;
}