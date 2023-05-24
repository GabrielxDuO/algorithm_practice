#include <iostream>
#include <cstring>

using namespace std;

typedef unsigned long long ULL;

const int N = 5e5 + 10;
int n, m;
int h[N], e[2 * N], ne[2 * N];
ULL w[2 * N];
int idx;
ULL d[N];

void add(int a, int b, ULL c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

int dfs(int a, int b) {
    for (int i = h[a]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == b) continue;
        d[v] = d[a] ^ w[i];
        dfs(v, a);
    }
    return 0;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n - 1; ++i) {
        int x, y;
        ULL l;
        scanf("%d%d%llu", &x, &y, &l);
        add(x, y, l), add(y, x, l);
    }
    dfs(1, 0);
    while (m--) {
        int a, b;
        ULL k;
        scanf("%d%d%llu", &a, &b, &k);
        puts((d[a] ^ d[b]) == k ? "YES" : "NO");
    }

    return 0;
}