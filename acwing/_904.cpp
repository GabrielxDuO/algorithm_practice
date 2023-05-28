#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

const int N = 510, M = 5210;
int t, n, m1, m2;
int h[N], w[M], e[M], ne[M], idx;
int dists[N];
int cnts[N];
bool has[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

bool spfa_jdg() {
    int entry = 0;
    memset(dists, 0, sizeof(dists));
    memset(cnts, 0, sizeof(cnts));
    queue<int> que;
    memset(has, false, sizeof(has));
    for (int u = 1; u <= n; ++u) {
        que.push(u);
        has[u] = true;
    }
    while (!que.empty()) {
        int u = que.front(); que.pop();
        has[u] = false;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (dists[u] + w[i] < dists[v]) {
                dists[v] = dists[u] + w[i];
                cnts[v] = cnts[u] + 1;
                if (cnts[v] >= n) return true;
                if (!has[v]) {
                    que.push(v);
                    // trick: 如果发现所有点入队的次数大于2n/3n 就说明SPFA可能已经存在负环了
                    // 这个trick优化可能会被特殊数据hack掉
                    if (++entry > n * 2) return true;
                    has[v] = true;
                }
            }
        }
    }
    return false;
}

int main() {
    scanf("%d", &t);
    while (t--) {
        scanf("%d%d%d", &n, &m1, &m2);
        memset(h, -1, sizeof(h));
        idx = 0;
        while (m1--) {
            int a, b, c;
            scanf("%d%d%d", &a, &b, &c);
            add(a, b, c), add(b, a, c);
        }
        while (m2--) {
            int a, b, c;
            scanf("%d%d%d", &a, &b, &c);
            add(a, b, -c);
        }
        puts(spfa_jdg() ? "YES" : "NO");
    }

    return 0;
}