#include <cstdio>
#include <cstring>

using namespace std;

const int N = 510, M = N * N;
int n, m;
int h[N], e[M], ne[M], idx;
int cnts[N];
int src, dest;
bool flag = true;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int dfs(int u) {
    if (~cnts[u]) return cnts[u];
    if (u == dest) return cnts[u] = 1;
    if (h[u] == -1 && u != dest) {
        flag = false;
        return cnts[u] = 0;
    }
    int cnt = 0;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        cnt += dfs(v);
    }
    return cnts[u] = cnt;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b; scanf("%d%d", &a, &b);
        add(a, b);
    }
    scanf("%d%d", &src, &dest);
    memset(cnts, -1, sizeof(cnts));
    int ans = dfs(src);
    printf(flag ? "%d Yes\n" : "%d No\n", ans);

    return 0;
}