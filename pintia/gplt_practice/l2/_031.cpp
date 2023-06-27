#include <cstdio>
#include <cstring>

using namespace std;

const int N = 1e5 + 10;
int n, k;
int h[N], e[N], ne[N], idx;
bool ind[N];
int root;
int que[N], hh, tt = -1;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int bfs(int u) {
    que[++tt] = u;
    int res = -1;
    while (hh <= tt) {
        int sz = tt - hh + 1;
        while (sz--) {
            u = que[hh++];
            if (h[u] == -1) res = u;
            for (int i = h[u]; ~i; i = ne[i]) {
                int v = e[i];
                que[++tt] = v;
            }
        }
    }
    return res;
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int u = 1; u <= n; ++u) {
        scanf("%d", &k);
        while (k--) {
            int v; scanf("%d", &v);
            add(u, v);
            ind[v] = true;
        }
    }
    for (int i = 1; i <= n; ++i) {
        if (!ind[i]) {
            root = i;
            break;
        }
    }
    printf("%d\n", bfs(root));

    return 0;
}