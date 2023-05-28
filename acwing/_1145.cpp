#include <iostream>
#include <algorithm>
#include <cmath>

#define fst first
#define sec second

using namespace std;

typedef pair<int, int> PII;

const int N = 510, M = N * N, INF = 0x3f3f3f3f;
int n, k;
PII poses[N];
struct Edge {
    int u, v;
    double w;

    bool operator<(const Edge& e) const {
        return w < e.w;
    }
} edges[M];
int len;
double dists[N];
int roots[N];

double get_dist(const PII& a, const PII& b) {
    return sqrt(pow(a.fst - b.fst, 2) + pow(a.sec - b.sec, 2));
}

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

double kruskal() {
    for (int i = 1; i <= n; ++i) {
        dists[i] = INF;
        roots[i] = i;
    }
    sort(edges, edges + len);
    int cnt = 0;
    double mx = 0.0;
    for (int i = 0; i < len; ++i) {
        int u = edges[i].u, v = edges[i].v;
        double w = edges[i].w;
        if (find(u) != find(v)) {
            mx = w;
            join(u, v);
            if (++cnt == n - 1 - k) break;
        }
    }
    return mx;
}

int main() {
    scanf("%d%d", &n, &k);
    if (k == n) {
        puts("0.00");
        return 0;
    }
    if (k) --k;
    for (int i = 1; i <= n; ++i) scanf("%d%d", &poses[i].first, &poses[i].second);
    for (int i = 1; i <= n; ++i) {
        for (int j = i + 1; j <= n; ++j) {
            double d = get_dist(poses[i], poses[j]);
            edges[len++] = {i, j, d};
        }
    }
    printf("%.2lf\n", kruskal());

    return 0;
}