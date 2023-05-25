#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int N = 110, M = 210, INF = 0x3f3f3f3f;
int n, m;
struct Edge {
    int u, v, w;

    bool operator<(const Edge& e) const {
        return w < e.w;
    }
};
vector<Edge> edges;
int roots[N];

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int kruskal() {
    for (int u = 1; u <= n; ++u) roots[u] = u;
    sort(edges.begin(), edges.end());
    int cnt = 0, res = 0;
    for (auto& [u, v, w] : edges) {
        if (find(u) != find(v)) {
            res += w;
            join(u, v);
            if (++cnt == n - 1) break;
        }
    }
    return res; // 不一定是连通图
}

int main() {
    scanf("%d%d", &n, &m);
    int sum = 0;
    for (int i = 0; i < m; ++i) {
        int u, v, w;
        scanf("%d%d%d", &u, &v, &w);
        edges.push_back({u, v, w});
        sum += edges[i].w;
    }
    printf("%d\n", sum - kruskal());

    return 0;
}