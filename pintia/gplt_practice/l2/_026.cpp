#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 1e5 + 10;
int n;
int h[N], e[N], ne[N], idx;
int root, w[N], mx;

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int dep) {
    mx = max(mx, dep);
    w[u] = dep;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        dfs(v, dep + 1);
    }
}

int main() {
    scanf("%d", &n);
    memset(h, -1, sizeof(h));
    for (int u = 1; u <= n; ++u) {
        int v; scanf("%d", &v);
        if (~v) add(v, u);
        else root = u;
    }
    dfs(root, 1);
    printf("%d\n", mx);
    bool first = true;
    for (int u = 1; u <= n; ++u) {
        if (w[u] == mx) {
            if (!first) printf(" ");
            else first = false;
            printf("%d", u);
        }
    }
    puts("");

    return 0;
}