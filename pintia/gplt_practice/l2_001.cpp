#include <cstdio>
#include <cstring>
#include <utility>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int N = 510, M = N * N * 2, INF = 0x3f3f3f3f;
int n, m, s, d;
int w1[N];
int h[N], w2[M], e[M], ne[M], idx;
int dists[N], cnts[N], nums[N];
bool vis[N];
int prevs[N];

void add(int a, int b, int c){
    e[idx] = b, w2[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dij(int src, int dest) {
    memset(dists, 0x3f, sizeof(dists));
    memset(prevs, -1, sizeof(prevs));
    dists[src] = 0;
    cnts[src] = 1;
    nums[src] = w1[src];
    priority_queue<PII, vector<PII>, greater<PII>> pq;
    pq.push({0, src});
    while (!pq.empty()) {
        PII u = pq.top(); pq.pop();
        int mn = u.second;
        if (vis[mn]) continue;
        vis[mn] = true;
        int d = u.first;
        for (int i = h[mn]; ~i; i = ne[i]) {
            int v = e[i];
            if (d + w2[i] < dists[v]) {
                dists[v] = d + w2[i];
                cnts[v] = cnts[mn];
                nums[v] = nums[mn] + w1[v];
                prevs[v] = mn;
                pq.push({dists[v], v});
            } else if (d + w2[i] == dists[v]) {
                if (nums[mn] + w1[v] > nums[v]) {
                    nums[v] = nums[mn] + w1[v];
                    prevs[v] = mn;
                }
                cnts[v] += cnts[mn];
            }
        }
    }
}

int main() {
    scanf("%d%d%d%d", &n, &m, &s, &d);
    for (int i = 0; i < n; ++i) scanf("%d", &w1[i]);
    memset(h, -1, sizeof(h));
    while (m--) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c), add(b, a, c);
    }
    dij(s, d);
    printf("%d %d\n", cnts[d], nums[d]);
    vector<int> path;
    while (d != s) {
        path.push_back(d);
        d = prevs[d];
    }
    path.push_back(s);
    for (int i = path.size() - 1; i >= 0; --i) {
        printf("%d", path[i]);
        printf(i ? " " : "\n");
    }

    return 0;
}