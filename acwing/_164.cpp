#include <cstdio>
#include <cstring>
#include <bitset>

using namespace std;

const int N = 3e4 + 10;
int n, m;
int ind[N];
int h[N], e[N], ne[N], idx;
int que[N];
int hh, tt = -1;
bitset<N> f[N];

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
        add(a, b);
        ++ind[b];
    }
    top_sort();
    for (int i = n - 1; i >= 0; --i) {
        int u = que[i];
        f[u][u] = 1;
        for (int j = h[u]; ~j; j = ne[j]) f[u] |= f[e[j]];
    }
    for (int u = 1; u <= n; ++u) printf("%d\n", f[u].count());

    return 0;
}