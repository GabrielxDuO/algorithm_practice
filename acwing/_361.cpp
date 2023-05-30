#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

const int N = 1010, M = 5010;
const double EPS = 1e-4;
int n, m;
int f[N];
int h[N], w[M], e[M], ne[M], idx;
double dists[N];
bool has[N];
int cnts[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

bool spfa_jdg(double m) {
    int entry = 0;
    memset(dists, 0, sizeof(dists));
    queue<int> que;
    memset(has, false, sizeof(has));
    memset(cnts, 0, sizeof(cnts));
    for (int u = 1; u <= n; ++u) que.push(u), has[u] = true;
    while (!que.empty()) {
        int u = que.front(); que.pop();
        has[u] = false;
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            double nd = dists[u] + (f[v] - m * w[i]);
            if (nd > dists[v]) {
                dists[v] = nd;
                cnts[v] = cnts[u] + 1;
                if (cnts[v] >= n) return true;
                if (!has[v]) {
                    que.push(v);
                    has[v] = true;
                    if (++entry > 2 * n) return true;
                }
            }
        }
    }
    return false;
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) scanf("%d", &f[i]);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c);
    }
    double l = 0.0, r = 1000.0;
    while (r - l > EPS) {
        double m = (l + r) / 2;
        if (spfa_jdg(m)) l = m;
        else r = m;
    }
    printf("%.2lf\n", l);

    return 0;
}