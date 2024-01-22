#include <cstdio>
#include <cmath>

using namespace std;

const int N = 6e5 + 10, K = log2(1e7) + 1;
int n, m;
int s[N];
char op[2];
int sons[N * K][2], vers[N * K], roots[N], idx;

void insert(int u, int p, int v) {
    vers[u] = v;
    for (int i = K - 1; i >= 0; --i) {
        int d = (s[v] >> i) & 1;
        sons[u][!d] = sons[p][!d];
        sons[u][d] = ++idx;
        u = sons[u][d], p = sons[p][d];
        vers[u] = v;
    }
}

int query(int x, int u, int l) {
    int res = 0;
    for (int i = K - 1; i >= 0; --i) {
        int d = (x >> i) & 1;
        if (vers[sons[u][!d]] >= l) res |= (1 << i), u = sons[u][!d];
        else u = sons[u][d];
    }
    return res;
}

int main() {
    scanf("%d%d", &n, &m);
    vers[0] = -1;
    roots[0] = ++idx;
    insert(roots[0], 0, 0);
    for (int i = 1; i <= n; ++i) {
        scanf("%d", &s[i]);
        s[i] ^= s[i - 1];
        roots[i] = ++idx;
        insert(roots[i], roots[i - 1], i);
    }
    while (m--) {
        scanf("%s", op);
        if (op[0] == 'A') {
            scanf("%d", &s[++n]);
            s[n] ^= s[n - 1];
            roots[n] = ++idx;
            insert(roots[n], roots[n - 1], n);
        } else {
            int l, r, x; scanf("%d%d%d", &l, &r, &x);
            int ans = query(s[n] ^ x, roots[r - 1], l - 1);
            printf("%d\n", ans);
        }
    }

    return 0;
}