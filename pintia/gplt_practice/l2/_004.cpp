#include <cstdio>

using namespace std;

const int N = 1010;
int n;
int pre[N], post[N], idx;

void dfs(int l, int r, bool type) {
    if (l > r) return;
    int u = l, lc = r, rc = l + 1;
    while (lc > l && (pre[lc] >= pre[u]) == type) --lc;
    while (rc <= r && (pre[rc] < pre[u]) == type) ++rc;
    if (lc + 1 != rc) return;
    dfs(u + 1, lc, type);
    dfs(rc, r, type);
    post[++idx] = pre[u];
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", &pre[i]);
    dfs(1, n, true);
    if (idx != n) {
        idx = 0;
        dfs(1, n, false);
    }
    if (idx != n) puts("NO");
    else {
        puts("YES");
        for (int i = 1; i <= n; ++i) {
            printf("%d", post[i]);
            printf(i == n ? "\n" : " ");
        }
    }

    return 0;
}