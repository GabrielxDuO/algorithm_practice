#include <cstdio>
#include <cmath>
#include <cstring>
#include <queue>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10, M = N * (int) (log2(N) + 2);
const LL INF = 0x3f3f3f3f3f3f3f3fLL;
int n;
int h[M], e[M], ne[M], w[M], idx;
int mp[N];
struct Node {
    int l, r;
} tr[N * 4];
int tot;
LL dists[M];
bool has[M];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void build(int u, int l, int r) {
    tr[u].l = l, tr[u].r = r;
    if (l == r) {
        mp[l] = u;
        tot = max(tot, u);
        return;
    }
    int m = l + r >> 1;
    build(u << 1, l, m);
    build(u << 1 | 1, m + 1, r);
    add(u, u << 1, 0);
    add(u, u << 1 | 1, 0);
}

void add(int u, int l, int r, int v, int st, int ed, int w) {
    if (l == st && r == ed) {
        add(v, u, w);
        return;
    }
    int m = l + r >> 1;
    if (ed <= m) add(u << 1, l, m, v, st, ed, w);
    else if (st >= m + 1) add(u << 1 | 1, m + 1, r, v, st, ed, w);
    else {
        add(u << 1, l, m, v, st, m, w);
        add(u << 1 | 1, m + 1, r, v, m + 1, ed, w);
    }
}

LL spfa(int src, int dest) {
    memset(dists, 0x3f, sizeof(dists));
    dists[src] = 0LL;
    queue<LL> que;
    que.push(src);
    has[src] = true;
    while (!que.empty()) {
        int u = que.front(); que.pop();
        has[u] = false;
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dists[u] + w[i] < dists[v]) {
                dists[v] = dists[u] + w[i];
                if (!has[v]) {
                    que.push(v);
                    has[v] = true;
                }
            }
        }
    }
    return dists[dest];
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    build(1, 1, n);
    for (int i = 1; i < n; ++i) {
        int l, r, w; scanf("%d%d%d", &l, &r, &w);
        add(1, 1, n, mp[i], l, r, w);
    }
    printf("%lld\n", spfa(mp[1], mp[n]));

    return 0;
}