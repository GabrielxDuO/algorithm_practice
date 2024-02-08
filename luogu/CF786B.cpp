#include <cstdio>
#include <cmath>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

typedef long long LL;
typedef pair<LL, int> PLI;

const int N = 1e5 + 10, M = N * (int) (log2(N) + 5);
const LL INF = 0x3f3f3f3f3f3f3f3fLL;
int n, q, s;
struct Node {
    int ln, rn;
} tr[N * 8];
int idx1, rt1, rt2;
int h[M], e[M], ne[M], w[M], idx2;
int op;
LL dists[M];
bool vis[M];

void add(int a, int b, int c, bool dir) {
    if (dir) e[idx2] = b, w[idx2] = c, ne[idx2] = h[a], h[a] = idx2++;
    else add(b, a, c, true);
}

void build(int u, int l, int r, bool dir) {
    if (l == r) return;
    if (l + 1 == r) tr[u].ln = l, tr[u].rn = r;
    else if (l + 2 == r) tr[u].rn = r;
    if (!tr[u].ln) tr[u].ln = ++idx1;
    if (!tr[u].rn) tr[u].rn = ++idx1;
    int m = l + r >> 1;
    build(tr[u].ln, l, m, dir);
    build(tr[u].rn, m + 1, r, dir);
    add(u, tr[u].ln, 0, dir);
    add(u, tr[u].rn, 0, dir);
}

void add(int u, int l, int r, int v, int st, int ed, int w, bool dir) {
    if (l == st && r == ed) {
        add(v, u, w, dir);
        return;
    }
    int m = l + r >> 1;
    if (ed <= m) add(tr[u].ln, l, m, v, st, ed, w, dir);
    else if (st >= m + 1) add(tr[u].rn, m + 1, r, v, st, ed, w, dir);
    else {
        add(tr[u].ln, l, m, v, st, m, w, dir);
        add(tr[u].rn, m + 1, r, v, m + 1, ed, w, dir);
    }
}

void dij(int src) {
    memset(dists + 1, 0x3f, idx1 * sizeof(LL));
    dists[src] = 0LL;
    priority_queue<PLI, vector<PLI>, greater<PLI>> heap;
    for (int i = 1; i <= idx1; ++i) heap.push({dists[i], i});
    while (!heap.empty()) {
        auto curr = heap.top();
        heap.pop();
        int mn = curr.second;
        if (vis[mn]) continue;
        LL dist = curr.first;
        vis[mn] = true;
        for (int i = h[mn]; ~i; i = ne[i]) {
            int v = e[i];
            if (dist + w[i] < dists[v]) {
                dists[v] = dist + w[i];
                heap.push({dists[v], v});
            }
        }
    }
}

int main() {
    scanf("%d%d%d", &n, &q, &s);
    memset(h, -1, sizeof(h));
    rt1 = idx1 = n + 1;
    build(rt1, 1, n, true);
    rt2 = ++idx1;
    build(rt2, 1, n, false);
    while (q--) {
        scanf("%d", &op);
        static int v, u, l, r, w;
        if (op == 1) {
            scanf("%d%d%d", &v, &u, &w);
            add(v, u, w, true);
        } else {
            scanf("%d%d%d%d", &v, &l, &r, &w);
            add(op == 2 ? rt1 : rt2, 1, n, v, l, r, w, op == 2);
        }
    }
    dij(s);
    for (int i = 1; i <= n; ++i) {
        printf("%lld ", dists[i] == INF ? -1 : dists[i]);
    }

    return 0;
}