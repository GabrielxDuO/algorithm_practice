#include <iostream>
#include <cstring>
#include <stack>

using namespace std;

const int N = 510, INF = 0x3f3f3f3f;
int n, m, s, d, g[N][N], c[N][N];
int dists[N], costs[N], prevs[N];
bool vis[N];

void dijkstra(int ori, int dest) {
    memset(dists, 0x3f, sizeof(dists));
    memset(costs, 0x3f, sizeof(costs));
    memset(prevs, -1, sizeof(prevs));
    dists[ori] = costs[ori] = 0;
    for (int i = 1; i < n; ++i) {
        int mn = -1;
        for (int j = 0; j < n; ++j) {
            if (!vis[j] && (mn == -1 || dists[j] < dists[mn])) mn = j;
        }
        vis[mn] = true;
        for (int j = 0; j < n; ++j) {
            int ind_dist = dists[mn] + g[mn][j], ind_cost = costs[mn] + c[mn][j];
            if (ind_dist < dists[j] || (ind_dist == dists[j] && ind_cost < costs[j])) {
                dists[j] = ind_dist;
                costs[j] = ind_cost;
                prevs[j] = mn;
            }
        }
    }
}

int main() {
    scanf("%d%d%d%d", &n, &m, &s, &d);
    memset(g, 0x3f, sizeof(g));
    memset(c, 0x3f, sizeof(c));
    while (m--) {
        int a, b, dist ,cost;
        scanf("%d%d%d%d", &a, &b, &dist, &cost);
        g[a][b] = g[b][a] = min(g[a][b], dist);
        c[a][b] = c[b][a] = min(c[a][b], cost);
    }
    dijkstra(s, d);
    stack<int> path;
    for (int i = d; ~i; i = prevs[i]) path.push(i);
    while (!path.empty()) {
        printf("%d ", path.top()), path.pop();
    }
    printf("%d %d\n", dists[d], costs[d]);

    return 0;
}