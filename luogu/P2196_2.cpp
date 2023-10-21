#include <iostream>
#include <cstring>
#include <queue>
#include <vector>

using namespace std;

const int N = 210, M = N * N;
int n;
int w[N];
int h[N], e[M], ne[M], idx;
int dists[N], prevs[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void spfa(int src) {
    queue<int> que;
    que.push(src);
    bool has[N];
    has[src] = true;
    while (!que.empty()) {
        int u = que.front(); que.pop();
        has[u] = false;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (dists[u] + w[v] > dists[v]) {
                dists[v] = dists[u] + w[v];
                prevs[v] = u;
                if (!has[v]) {
                    que.push(v);
                    has[v] = true;
                }
            }
        }
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &w[i]);
    memset(h, -1, sizeof(h));
    for (int i = 1; i <= n; ++i) add(n + 1, i);
    for (int i = 1; i < n; ++i) {
        for (int j = i + 1; j <= n; ++j) {
            int con; scanf("%d", &con);
            if (con) add(i, j);
        }
    }
    spfa(n + 1); 
    int mx = 0, mx_u;
    for (int u = 1; u <= n; ++u) {
        if (dists[u] > mx) {
            mx = dists[u];
            mx_u = u;
        }
    }
    vector<int> path;
    for (int u = mx_u; u <= n; u = prevs[u]) path.push_back(u);
    for (int i = path.size() - 1; i >= 0; --i) printf("%d ", path[i]);
    printf("\n%d\n", mx);

    return 0;
}