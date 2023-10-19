#include <cstdio>
#include <cstring>
#include <queue>

using namespace std;

const int N = 2e5 + 10, INF = 0x3f3f3f3f;
int n, a[N];
int h[N], e[N * 2], ne[N * 2], idx;
bool vis[N];
int odd_dists[N], even_dists[N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &a[i]);
        if (i + a[i] <= n) add(i + a[i], i);
        if (i - a[i] >= 1) add(i - a[i], i);
    }
    memset(odd_dists, 0x3f, sizeof(odd_dists));
    memset(even_dists, 0x3f, sizeof(even_dists));
    queue<int> que;
    for (int i = 1; i <= n; ++i) {
        if (a[i] & 1) {
            odd_dists[i] = 0;
            que.push(i);
        }
    }
    while (!que.empty()) {
        int u = que.front(); que.pop();
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (odd_dists[v] > odd_dists[u] + 1) {
                odd_dists[v] = odd_dists[u] + 1;
                que.push(v);
            }
        }
    }
    for (int i = 1; i <= n; ++i) {
        if ((a[i] & 1) == 0) {
            even_dists[i] = 0;
            que.push(i);
        }
    }
    memset(vis, false, sizeof(vis));
    while (!que.empty()) {
        int u = que.front(); que.pop();
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (even_dists[v] > even_dists[u] + 1) {
                even_dists[v] = even_dists[u] + 1;
                que.push(v);
            }
        }
    }
    for (int i = 1; i <= n; ++i) {
        if (a[i] & 1) printf("%d ", even_dists[i] == INF ? -1 : even_dists[i]);
        else printf("%d ", odd_dists[i] == INF ? -1 : odd_dists[i]);
    }

    return 0;
}