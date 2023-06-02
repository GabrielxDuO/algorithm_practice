#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 2e5 + 10;
int m, p, a, n;
struct Node {
    int l, r, mx;
} tr[N * 4];

void pushup(int u) {
    tr[u].mx = max(tr[u << 1].mx, tr[u << 1 | 1].mx);
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) return; // 这题数组中没初值 找到叶子节点了可以不赋值
    int m = l + r >> 1;
    build(u << 1, l, m);
    build(u << 1 | 1, m + 1, r);
    // pushup(u); // 同上可以不做pushup操作
}

int query(int u, int l, int r) {
    if (tr[u].l >= l && tr[u].r <= r) return tr[u].mx;
    int m = tr[u].l + tr[u].r >> 1;
    int res = 0;
    if (l <= m) res = max(res, query(u << 1, l, r));
    if (r >= m + 1) res = max(res, query(u << 1 | 1, l, r));
    return res;
}

void modify(int u, int i, int x) {
    if (tr[u].l == tr[u].r) tr[u].mx = x;
    else {
        int m = tr[u].l + tr[u].r >> 1;
        if (i <= m) modify(u << 1, i, x);
        else modify(u << 1 | 1, i, x);
        pushup(u);
    }
}

int main() {
    scanf("%d%d", &m, &p);
    char op[2];
    int x;
    build(1, 1, m);
    while (m-- > 0) {
        scanf("%s%d", op, &x);
        if (op[0] == 'Q') {
            a = query(1, n - x + 1, n);
            printf("%d\n", a);
        } else modify(1, ++n, (1LL * x + a) % p);
        // 由于输入的数x和上一次查询到的数a范围都是[1,2e9] 这里查到的数可能会爆int
    }

    return 0;
}