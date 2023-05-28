```cpp
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 6010;
int n, t;
struct Edge {
    int u, v, w;
    
    bool operator<(const Edge& e) const {
        return w < e.w;
    }
} edges[N];
int roots[N];
int sizes[N];

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    p = find(p), q = find(q);
    if (p == q) return;
    roots[p] = q;
    sizes[q] += sizes[p];
}

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d", &n);
        for (int i = 0; i < n - 1; ++i) {
            scanf("%d%d%d", &edges[i].u, &edges[i].v, &edges[i].w);
        }
        sort(edges, edges + n - 1);
        for (int i = 1; i <= n; ++i) roots[i] = i, sizes[i] = 1;
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            int u = find(edges[i].u), v = find(edges[i].v), w = edges[i].w;
            if (u != v) {
                ans += (sizes[u] * sizes[v] - 1) * (w + 1);
                join(u, v);
            }
        }
        printf("%d\n", ans);
    }

    return 0;
}
```