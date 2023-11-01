#include <cstdio>
#include <algorithm>

using namespace std;

// https://gabrielxd.top/archives/acwing-245的变形加懒标记版本
const int N = 5e5 + 10;
int n, q;
char s[N];
struct Node {
    int l, r, c;
    int mx[2], lmx[2], rmx[2];
    bool lazy;

    void set(int x) {
        mx[x] = lmx[x] = rmx[x] = 1;
    }
} tr[N * 4];

void push_up(Node& un, Node& ln, Node& rn) {
    for (int i = 0; i <= 1; ++i) {
        un.lmx[i] = ln.r - ln.l + 1 == ln.lmx[i] ? ln.r - ln.l + 1 + rn.lmx[i] : ln.lmx[i];
        un.rmx[i] = rn.r - rn.l + 1 == rn.rmx[i] ? rn.r - rn.l + 1 + ln.rmx[i] : rn.rmx[i];
        un.mx[i] = max(max(ln.mx[i], rn.mx[i]), ln.rmx[i] + rn.lmx[i]);
    }
}

void push_up(int u) {
    push_up(tr[u], tr[u << 1], tr[u << 1 | 1]);
}

void swap(Node& u) {
    swap(u.mx[0], u.mx[1]), swap(u.lmx[0], u.lmx[1]), swap(u.rmx[0], u.rmx[1]);
}

void push_down(int u) {
    bool& lazy = tr[u].lazy;
    if (!lazy) return;
    tr[u << 1].lazy ^= 1, swap(tr[u << 1]);
    tr[u << 1 | 1].lazy ^= 1, swap(tr[u << 1 | 1]);
    lazy = false;
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) tr[u].set(s[l] - '0');
    else {
        int m = l + r >> 1;
        build(u << 1, l, m);
        build(u << 1 | 1, m + 1, r);
        push_up(u);
    }
}

void modify(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) {
        tr[u].lazy = !tr[u].lazy;
        swap(tr[u]);
    } else {
        push_down(u);
        int m = tr[u].l + tr[u].r >> 1;
        if (m >= l) modify(u << 1, l, r);
        if (m + 1 <= r) modify(u << 1 | 1, l, r);
        push_up(u);
    }
}

Node query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u];
    push_down(u);
    int m = tr[u].l + tr[u].r >> 1;
    if (m >= r) return query(u << 1, l, r);
    else if (m + 1 <= l) return query(u << 1 | 1, l, r);
    Node res;
    Node ln = query(u << 1, l, r), rn = query(u << 1 | 1, l, r);
    push_up(res, ln, rn);
    return res;
}

int main() {
    scanf("%d%d%s", &n, &q, s + 1);
    build(1, 1, n);
    int x = 1;
    while (q--) {
        int c, l, r;
        scanf("%d%d%d", &c, &l, &r);
        if (c == 1) modify(1, l, r);
        else printf("%d\n", query(1, l, r).mx[1]);
    }

    return 0;
}