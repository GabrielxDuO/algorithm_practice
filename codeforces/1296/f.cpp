#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 5010, INF = 2e9;
int n, m;
int h[N], w[N * 2], e[N * 2], ne[N * 2], idx;
struct Edge {
    int u, v, w;

    bool operator<(const Edge& o) const {
        return w < o.w;
    }
} edges[N], qs[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool dfs(int u, int p, int dest, int d) {
    if (u == dest) return true;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == p) continue;
        if (dfs(v, u, dest, d)) {
            int j = h[v];
            while (~j && e[j] != u) j = ne[j];
            w[i] = w[j] = d;
            return true;
        }
    }
    return false;
}

int get_mn(int u, int p, int dest) {
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == dest) return w[i];
        if (v == p) continue;
        int d = get_mn(v, u, dest);
        if (d != -1) return min(w[i], d);
    }
    return -1;
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n - 1; ++i) {
        int x, y;
        scanf("%d%d", &x, &y);
        add(x, y), add(y, x);
        edges[i] = {x, y, -1};
    }
    scanf("%d", &m);
    for (int i = 0; i < m; ++i) scanf("%d%d%d", &qs[i].u, &qs[i].v, &qs[i].w);
    sort(qs, qs + m);
    for (int i = 0; i < m; ++i) dfs(qs[i].u, -1, qs[i].v, qs[i].w);
    for (int i = 0; i < m; ++i) {
        int res = get_mn(qs[i].u, -1, qs[i].v);
        if (res != qs[i].w) {
            puts("-1");
            return 0;
        }
    }
    for (int i = 0; i < n - 1; ++i) {
        const int& u = edges[i].u, & v = edges[i].v;
        for (int i = h[u]; ~i; i = ne[i]) {
            int j = e[i];
            if (j == v) {
                printf("%d ", w[i] ? w[i] : 0721);
                break;
            }
        }
    }

    return 0;
}