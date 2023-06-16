#include <cstdio>
#include <cstring>
#include <unordered_set>

using namespace std;

const int N = 1e5 + 10;
int n, k;
bool sex[N];
int fa[N], mo[N];
unordered_set<int> vis;
int que[100], hh, tt;

bool check(int a, int b) {
    hh = 0, tt = -1;
    que[++tt] = a;
    vis.clear();
    for (int i = 0; i < 5; ++i) {
        int sz = tt - hh + 1;
        while (sz--) {
            int u = que[hh++];
            vis.insert(u);
            if (~fa[u]) que[++tt] = fa[u];
            if (~mo[u]) que[++tt] = mo[u];
        }
    }
    hh = 0, tt = -1;
    que[++tt] = b;
    for (int i = 0; i < 5; ++i) {
        int sz = tt - hh + 1;
        while (sz--) {
            int u = que[hh++];
            if (vis.find(u) != vis.end()) return true;
            if (~fa[u]) que[++tt] = fa[u];
            if (~mo[u]) que[++tt] = mo[u];
        }
    }
    return false;
}

int main() {
    scanf("%d", &n);
    memset(fa, -1, sizeof(fa));
    memset(mo, -1, sizeof(mo));
    while (n--) {
        int u;
        char s[2];
        scanf("%d%s", &u, s);
        scanf("%d%d", &fa[u], &mo[u]);
        sex[fa[u]] = 1;
        sex[mo[u]] = 0;
        sex[u] = (s[0] == 'M');
    }
    scanf("%d", &k);
    while (k--) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (sex[a] == sex[b]) puts("Never Mind");
        else puts(check(a, b) ? "No" : "Yes");
    }

    return 0;
}