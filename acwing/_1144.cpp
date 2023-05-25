#include <iostream>
#include <algorithm>

using namespace std;

const int N = 1010, M = 1e6 + 10, K = 2 * M;
// 对每个点向右下连边 横向权值为2 纵向为1
const int DIRS[][3] = {{0, 1, 2}, {1, 0, 1}};
int n, m;
struct Edge {
    int u, v, w;

    bool operator<(const Edge& e) const {
        return w < e.w;
    }
} edges[K];
int len;
int roots[M];

// 拍扁二维坐标
int conv(int x, int y) {
    return x * m + y;
}

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int kruskal() {
    sort(edges, edges + len);
    int res = 0;
    for (int i = 0; i < len; ++i) {
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
    int cnt = n * m;
    for (int i = 1; i < cnt; ++i) roots[i] = i;
    int x1, y1, x2, y2;
    while (~scanf("%d%d%d%d", &x1, &y1, &x2, &y2)) {
        join(conv(x1 - 1, y1 - 1), conv(x2 - 1, y2 - 1));
    }
    for (int x = 0; x < n; ++x) {
        for (int y = 0; y < m; ++y) {
            int a = conv(x, y);
            for (auto& DIR : DIRS) {
                int nx = x + DIR[0], ny = y + DIR[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int b = conv(nx, ny);
                if (find(a) == find(b)) continue;
                edges[len++] = {a, b, DIR[2]};
            }
        }
    }
    printf("%d\n", kruskal());

    return 0;
}