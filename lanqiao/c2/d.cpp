#include <cstdio>
#include <cstring>
#include <algorithm>
#include <queue>

using namespace std;

const int N = 1e5 + 10;
int n, p;
int h[N], s[N], k[N], e[N], ne[N], idx;
int prevs[N];
bool vis[N];

struct VtxCmp {
    bool operator()(const int& a, const int& b) const {
        return k[a] > k[b];
    }
};

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

int main() {
    scanf("%d%d", &n, &p);
    memset(h, -1, sizeof(h));
    for (int u = 1; u <= n; ++u) {
        int f; scanf("%d%d%d", &f, &s[u], &k[u]);
        add(f, u);
    }
    int ans = 0;
    priority_queue<int, vector<int>, VtxCmp> pq;
    pq.push(1);
    while (!pq.empty()) {
        int u = pq.top(); pq.pop();
        if (p < k[u]) break;
        p += s[u];
        ++ans;
        for (int i = h[u]; ~i; i = ne[i]) pq.push(e[i]);
    }
    printf("%d\n", ans);

    return 0;
}