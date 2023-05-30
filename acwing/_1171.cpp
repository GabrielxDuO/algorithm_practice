#include <cstdio>
#include <cstring>
#include <vector>

#define fst first
#define sec second

using namespace std;

typedef pair<int, int> PII;

const int N = 1e4 + 10, M = 2e4 + 10;
int n, m;
int h[N], w[M], e[M], ne[M], idx;
int dists[N];
int roots[N];
int marks[N];
vector<PII> qs[N];
int ans[M];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u, int p) {
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (v == p) continue;
        dists[v] = dists[u] + w[i];
        dfs(v, u); 
    }
}

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

void tarjan(int u) {
    marks[u] = 1;
    for (int i = h[u]; ~i; i = ne[i]) {
        int v = e[i];
        if (marks[v]) continue;
        tarjan(v);
        join(v, u);
    }
    for (PII& q : qs[u]) {
        int v = q.fst, id = q.sec;
        if (marks[v] == 2) {
            ans[id] = dists[u] + dists[v] - 2 * dists[find(v)];
        }
    }
    marks[u] = 2;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    for (int i = 0; i < n - 1; ++i) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
    }
    dfs(1, -1);
    for (int i = 0; i < m; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (a != b) {
            qs[a].push_back({b, i});
            qs[b].push_back({a, i});
        }
    }
    for (int i = 1; i <= n; ++i) roots[i] = i;
    tarjan(1);
    for (int i = 0; i < m; ++i) printf("%d\n", ans[i]);

    return 0;
}