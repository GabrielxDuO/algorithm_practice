#include <iostream>
#include <algorithm>

using namespace std;

const int N = 310, M = 2e4;
int n, m;
struct Edge {
    int u, v, w;

    bool operator<(const Edge& e) const {
        return w < e.w;
    }
} edges[M];
int roots[N];
int mx;

int find(int x) {
    return x == roots[x] ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int kruskal() {
    for (int i = 1; i <= n; ++i) roots[i] = i;
    sort(edges, edges + m);
    int cnt = 0;
    for (int i = 0; i < m; ++i) {
        int u = edges[i].u, v = edges[i].v, w = edges[i].w;
        if (find(u) != find(v)) {
            mx = w;
            ++cnt;
            join(u, v);
        }
    }
    return cnt;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        scanf("%d%d%d", &edges[i].u, &edges[i].v, &edges[i].w);
    }
    printf("%d ", kruskal());
    printf("%d\n", mx);

    return 0;
}