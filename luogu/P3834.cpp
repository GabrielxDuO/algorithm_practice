#include <cstdio>
#include <algorithm>
#include <cstring>
#include <cmath>

using namespace std;

const int N = 2e5 + 10, K = log2(N) + 4;
int n, m;
int a[N], alls[N], len;
struct Node {
    int ln, rn;
    int cnt;
} tr[N * K];
int roots[N], tot;

int get(int x) {
    return lower_bound(alls + 1, alls + len + 1, x) - alls;
}

void build(int& u, int l, int r) {
    u = ++tot;
    if (l == r) return;
    int m = l + r >> 1;
    build(tr[u].ln, l, m);
    build(tr[u].rn, m + 1, r);
}

void insert(int& u, int p, int l, int r, int x) {
    u = ++tot, tr[u] = tr[p], ++tr[u].cnt;
    if (l == r) return;
    int m = l + r >> 1;
    if (x <= m) insert(tr[u].ln, tr[p].ln, l, m, x);
    else insert(tr[u].rn, tr[p].rn, m + 1, r, x);
}

int query(int u, int p, int l, int r, int k) {
    if (l == r) return l;
    int m = l + r >> 1;
    int lc = tr[tr[u].ln].cnt - tr[tr[p].ln].cnt;
    if (k <= lc) return query(tr[u].ln, tr[p].ln, l, m, k);
    else return query(tr[u].rn, tr[p].rn, m + 1, r, k - lc);
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
    memcpy(alls + 1, a + 1, n * sizeof(int));
    sort(alls + 1, alls + n + 1);
    len = unique(alls + 1, alls + n + 1) - (alls + 1);
    build(roots[0], 1, len);
    for (int i = 1; i <= n; ++i) insert(roots[i], roots[i - 1], 1, len, get(a[i]));
    while (m--) {
        int l, r, k; scanf("%d%d%d", &l, &r, &k);
        int pos = query(roots[r], roots[l - 1], 1, len, k);
        printf("%d\n", alls[pos]);
    }

    return 0;
}