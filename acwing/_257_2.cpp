#include <iostream>
#include <cstring>

using namespace std;

const int N = 2e4 + 10, M = 2e5 + 10;
int n, m;
int h[N], w[M], e[M], ne[M], idx;
int roots[N * 2];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

bool check(int m) {
    for (int u = 1; u <= n * 2; ++u) roots[u] = u;
    for (int u = 1; u <= n; ++u) {
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (w[i] <= m) continue;
            if (find(u) == find(v)) return false;
            join(u, v + n), join(v, u + n);
        }
    }
    return true;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    int mx = 0;
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
        if (c > mx) mx = c;
    }
    int l = 0, r = mx;
    while (l < r) {
        int m = l + r >> 1;
        if (check(m)) r = m;
        else l = m + 1;
    }
    printf("%d\n", l);

    return 0;
}