#include <cstdio>
#include <iostream>
#include <unordered_map>
#include <cstring>
#include <queue>
#include <stack>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

const int N = 210, K = N * N;
int n, k;
unordered_map<string, int> mp;
unordered_map<int, string> rev_mp;
int cnts[N];
int h[N], w[K], e[K], ne[K], idx;
int dists[N], ways[N];
struct Info {
    int u, d;

    bool operator<(const Info& o) const {
        if (d != o.d) return d > o.d;
        return cnts[u] > cnts[o.u];
    }
};
priority_queue<Info> pq;
bool vis[N];
int prevs[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

void dij(int src, int dest) {
    memset(dists, 0x3f, sizeof(dists));
    dists[src] = 0;
    ways[src] = 1;
    pq.push({src, 0});
    prevs[src] = -1;
    while (!pq.empty()) {
        Info curr = pq.top(); pq.pop();
        int mn = curr.u;
        if (vis[mn]) continue;
        vis[mn] = true;
        int d = curr.d;
        for (int i = h[mn]; ~i; i = ne[i]) {
            int v = e[i];
            if (d + w[i] < dists[v]) {
                dists[v] = d + w[i];
                ways[v] = ways[mn];
                pq.push({v, dists[v]});
                prevs[v] = mn;
            } else if (d + w[i] == dists[v]) ways[v] += ways[mn];
        }
    }
}

int main() {
    string st, ed;
    cin >> n >> k >> st >> ed;
    mp[st] = ++idx;
    rev_mp[idx] = st;
    string s;
    while (--n) {
        cin >> s >> cnts[++idx];
        mp[s] = idx;
        rev_mp[idx] = s;
    }
    idx = 0;
    string a, b;
    int c;
    memset(h, -1, sizeof(h));
    while (k--) {
        cin >> a >> b >> c;
        add(mp[a], mp[b], c), add(mp[b], mp[a], c);
    }
    int src = mp[st], dest = mp[ed];
    dij(src, dest);
    int u = prevs[dest];
    stack<string> stk;
    int tot = 0;
    while (~u) {
        stk.push(rev_mp[u]);
        tot += cnts[u];
        u = prevs[u];
    }
    while (!stk.empty()) {
        cout << stk.top() << "->";
        stk.pop();
    }
    cout << ed << '\n';
    cout << ways[dest] << ' ' << dists[dest] << ' ' << tot;

    return 0;
}