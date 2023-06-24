#include <cstdio>

using namespace std;

const int N = 200;
int type[N], val[N], l[N], r[N];
bool is_child[N];
int eds[N];
int n, root, cnt, k;

void dfs1(int u) {
    if (!u) return;
    dfs1(l[u]);
    if (u > n) eds[cnt++] = u;
    dfs1(r[u]);
}

int dfs2(int u) {
    if (u > n) return val[u];
    int lv = dfs2(l[u]);
    if (type[u] == 3) return !lv;
    int rv = dfs2(r[u]);
    if (type[u] == 1) return lv & rv;
    if (type[u] == 2) return lv | rv;
}

int main() {
    scanf("%d", &n);
    cnt = n;
    for (int u = 1; u <= n; ++u) {
        scanf("%d%d", &type[u], &l[u]);
        if (!l[u]) l[u] = ++cnt;
        if (type[u] != 3) {
            scanf("%d", &r[u]);
            if (!r[u]) r[u] = ++cnt;
        }
        is_child[l[u]] = is_child[r[u]] = true;
    }
    for (int u = 1; u <= n; ++u) {
        if (!is_child[u]) root = u;
    }
    cnt = 0;
    dfs1(root);
    scanf("%d", &k);
    while (k--) {
        scanf("\n");
        char c;
        for (int i = 0; i < cnt; ++i) {
            scanf("%c", &c);
            val[eds[i]] = c - '0';
        }
        puts(dfs2(root) ? "Ai" : "BuAi");
    }

    return 0;
}