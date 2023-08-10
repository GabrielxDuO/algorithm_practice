#include <cstdio>
#include <cstring>
#include <queue>
#include <string>
#include <stack>

#define fi first;
#define se second;

using namespace std;

typedef pair<int, int> PII;

const int N = 510, M = N * N;
int n, m;
int h[N], w[M][2], e[M], ne[M], idx;
int dists[N][2], prevs[N];
bool vis[N];
string p1, p2;

void add(int a, int b, int c, int d) {
    e[idx] = b, w[idx][0] = c, w[idx][1] = d, ne[idx] = h[a], h[a] = idx++;
}

void dij(int src, int dest, int type) {
    memset(dists, 0x3f, sizeof(dists));
    dists[src][type] = 0;
    memset(vis, false, sizeof(vis));
    priority_queue<PII, vector<PII>, greater<PII>> pq;
    memset(prevs, -1, sizeof(prevs));
    pq.push({0, src});
    while (!pq.empty()) {
        PII curr = pq.top(); pq.pop();
        int mn = curr.se;
        if (vis[mn]) continue;
        vis[mn] = true;
        int d = curr.fi;
        for (int i = h[mn]; ~i; i = ne[i]) {
            int v = e[i];
            int nd = d + w[i][type], ano_nd = dists[mn][!type] + (type ? w[i][!type] : 1);
            if (nd < dists[v][type] || nd == dists[v][type] && ano_nd < dists[v][!type]) {
                dists[v][type] = nd;
                dists[v][!type] = ano_nd;
                prevs[v] = mn;
                pq.push({dists[v][type], v});
            }
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b, ow, c, d;
        scanf("%d%d%d%d%d", &a, &b, &ow, &c, &d);
        add(a, b, c, d);
        if (!ow) add(b, a, c, d);
    }
    int s, t;
    scanf("%d%d", &s, &t);
    dij(s, t, 1);
    printf("Time = %d", dists[t][1]);
    int u = t;
    stack<int> stk;
    while (~u) {
        stk.push(u);
        u = prevs[u];
    }
    while (!stk.empty()) {
        u = stk.top(); stk.pop();
        p1 += " " + to_string(u);
        if (!stk.empty()) p1 += " =>";
    }
    dij(s, t, 0);
    while (~u) {
        stk.push(u);
        u = prevs[u];
    }
    while (!stk.empty()) {
        u = stk.top(); stk.pop();
        p2 += " " + to_string(u);
        if (!stk.empty()) p2 += " =>";
    }
    if (p1 == p2) printf("; ");
    else printf(":%s\n", p1.c_str());
    printf("Distance = %d:", dists[t][0]);
    printf("%s\n", p2.c_str());

    return 0;
}