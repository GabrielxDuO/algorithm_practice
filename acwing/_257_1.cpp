#include <iostream>
#include <cstring>

using namespace std;

const int N = 2e4 + 10, M = 2e5 + 10;
int n, m;
int h[N], w[M], e[M], ne[M], idx;
int colors[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

bool dye(int u, int c, int m) {
    colors[u] = c;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (w[i] <= m) continue;
        if (colors[v] == c || !colors[v] && !dye(v, 3 - c, m)) return false;
    }
    return true;
}

bool check(int m) {
    memset(colors, 0, sizeof(colors));
    for (int u = 1; u <= n; ++u) {
        if (!colors[u] && !dye(u, 1, m)) return false;
    }
    return true;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
    }
    int l = 0, r = 1e9;
    while (l < r) {
        int m = l + r >> 1;
        if (check(m)) r = m;
        else l = m + 1;
    }
    printf("%d\n", l);

    return 0;
}