#include <cstdio>
#include <cstring>
#include <queue>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 1e3 + 10, M = 1e6 + 10;
int n, m, cnt;
int h[M], e[M], ne[M], idx;
int ind[M];
int g[N][N], mp[M], rev_mp[M];

struct Cmp {
    bool operator()(const PII& x, const PII& y) {
        if (x.fi != y.fi) return x.fi > y.fi;
        return rev_mp[x.se] > rev_mp[y.se];
    }
};

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void top_sort() {
    priority_queue<PII, vector<PII>, Cmp> pq;
    for (int u = 1; u <= cnt; ++u) pq.push({ind[u], u});
    for (int i = 0; i < cnt; ) {
        if (pq.top().fi) {
            puts("Impossible");
            return;
        }
        auto pr = pq.top(); pq.pop();
        int u = pr.se;
        printf("%d", rev_mp[u]);
        if (++i != cnt) printf(" ");
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            --ind[v];
            pq.push({ind[v], v});
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            scanf("%d", &g[i][j]);
            if (!mp[g[i][j]]) {
                mp[g[i][j]] = ++cnt;
                rev_mp[cnt] = g[i][j];
            }
            if (i && g[i][j] != g[i - 1][j]) {
                ++ind[mp[g[i][j]]];
                add(mp[g[i - 1][j]], mp[g[i][j]]);
            }
        }
    }
    
    top_sort();

    return 0;
}