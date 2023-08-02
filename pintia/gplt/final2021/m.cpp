#include <iostream>
#include <cstring>
#include <algorithm>
#include <set>
#include <queue>

using namespace std;

typedef long long LL;
typedef pair<LL, int> PII;

const int N = 100010, M = 200010 * 2;
const LL INF = 0x3f3f3f3f3f3f3f3fLL;

int n, m, q;
int h1[N], h2[N], e[M], w[M], ne[M], idx;
LL dist1[N], dist2[N];
bool st[N];
int ratio[N];

void add(int h[], int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dij(int h[], LL dist[], int src) {
    memset(dist, 0x3f, sizeof dist1);
    memset(st, 0, sizeof st);
    dist[src] = 0;
    priority_queue<PII, vector<PII>, greater<PII>> pq;
    pq.push({0, src});
    while (pq.size()) {
        auto t = pq.top();
        int u = t.second;
        pq.pop();
        if (st[u]) continue;
        st[u] = true;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (dist[v] > dist[u] + w[i]) {
                dist[v] = dist[u] + w[i];
                pq.push({dist[v], v});
            }
        }
    }
}

int main() {
    scanf("%d%d%d", &n, &m, &q);
    memset(h1, -1, sizeof h1);
    memset(h2, -1, sizeof h2);
    while (m--) {
        int a, b, c, d;
        scanf("%d%d%d%d", &a, &b, &c, &d);
        add(h1, a, b, c), add(h2, b, a, d);
    }
    for (int i = 1; i <= n; ++i) scanf("%d", &ratio[i]);
    dij(h1, dist1, 1);
    dij(h2, dist2, n);
    multiset<LL> st;
    for (int i = 1; i <= n; ++i) {
        if (dist1[i] != INF && dist2[i] != INF) {
            st.insert(dist1[i] + (dist2[i] + ratio[i] - 1) / ratio[i]);
        }
    }
    while (q--) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (dist1[a] != INF && dist2[a] != INF) {
            st.erase(st.find(dist1[a] + (dist2[a] + ratio[a] - 1) / ratio[a]));
            ratio[a] = b;
            st.insert(dist1[a] + (dist2[a] + ratio[a] - 1) / ratio[a]);
        }
        printf("%lld\n", *st.begin());
    }

    return 0;
}