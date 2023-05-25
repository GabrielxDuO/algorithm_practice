#include <iostream>
#include <algorithm>

using namespace std;

const int N = 2010, M = 10010;
int n, m;
struct Edge {
    int u, v, w;

    bool operator<(const Edge& e) const {
        return w < e.w;
    }
} edges[M];
int roots[N];
int cnt;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int kruskal() {
    sort(edges, edges + cnt);
    int res = 0;
    for (int i = 0; i < cnt; ++i) {
        int u = edges[i].u, v = edges[i].v, w = edges[i].w;
        if (find(u) != find(v)) {
            res += w;
            join(u, v);
        }
    }
    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) roots[i] = i;
    int ans = 0;
    while (m--) {
        int p, u, v, w;
        scanf("%d%d%d%d", &p, &u, &v, &w);
        if (p == 1) join(u, v), ans += w;
        else edges[cnt++] = {u, v, w};
    }
    ans += kruskal();
    printf("%d\n", ans);

    return 0;
}