#include <iostream>
#include <cstring>

using namespace std;

const int N = 1e4 + 10, M = 2e4 + 10;
int n, m;
int ind[N];
int h[N], e[M], ne[M], idx;
int que[N];
int hh, tt = -1;
int dists[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

bool top_sort() {
    for (int u = 1; u <= n; ++u) {
        if (!ind[u]) que[++tt] = u;
    }
    while (hh <= tt) {
        int u = que[hh++];
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (--ind[v] == 0) que[++tt] = v;
        }
    }
    return tt == n - 1;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(b, a);
        ++ind[a];
    }
    if (!top_sort()) puts("Poor Xed");
    else {
        for (int u = 1; u <= n; ++u) dists[u] = 100;
        for (int i = 0; i < n; ++i) {
            int u = que[i];
            for (int j = h[u]; ~j; j = ne[j]) {
                int v = e[j];
                dists[v] = max(dists[v], dists[u] + 1);
            }
        }
        int ans = 0;
        for (int u = 1; u <= n; ++u) ans += dists[u];
        printf("%d\n", ans);
    }

    return 0;
}