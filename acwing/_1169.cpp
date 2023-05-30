#include <cstdio>
#include <cstring>
#include <stack>

using namespace std;

typedef long long LL;

const int N = 1e5 + 10, M = 3e5 + 10;
int n, m;
int h[N], w[M], e[M], ne[M], idx;
int dists[N];
bool has[N];
int cnts[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

bool spfa() {
    memset(dists, -0x3f, sizeof(dists));
    dists[0] = 0;
    stack<int> stk;
    stk.push(0);
    has[0] = true;
    while (!stk.empty()) {
        int u = stk.top(); stk.pop();
        has[u] = false;
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (dists[u] + w[i] > dists[v]) {
                dists[v] = dists[u] + w[i];
                cnts[v] = cnts[u] + 1;
                if (cnts[u] >= n + 1) return false;
                if (!has[v]) {
                    stk.push(v);
                    has[v] = true;
                }
            }
        }
    }
    return true;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int x, a, b;
        scanf("%d%d%d", &x, &a, &b);
        if (x == 1) add(a, b, 0), add(b, a, 0);
        else if (x == 2) add(a, b, 1);
        else if (x == 3) add(b, a, 0);
        else if (x == 4) add(b, a, 1);
        else add(a, b, 0);
    }
    for (int u = 1; u <= n; ++u) add(0, u, 1);
    if (!spfa()) puts("-1");
    else {
        LL ans = 0L;
        for (int u = 1; u <= n; ++u) ans += dists[u];
        printf("%lld\n", ans);
    }

    return 0;
}