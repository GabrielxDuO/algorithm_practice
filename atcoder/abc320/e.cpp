#include <cstdio>
#include <algorithm>
#include <queue>
#include <stack>
#include <unordered_map>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;
typedef long long LL;

const int N = 2e5 + 10;
int n, m;
int alls[N * 2];
unordered_map<int, PII> mp;
unordered_map<int, vector<int>> out_mp;
LL ans[N];

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 0; i < m; ++i) {
        int t, w, s;
        scanf("%d%d%d", &t, &w, &s);
        mp[t] = {w, s};
        alls[i] = t, alls[i + m] = t + s;
    }
    sort(alls, alls + m * 2);
    int len = unique(alls, alls + m * 2) - alls;
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = n; i >= 1; --i) pq.push(i);
    for (int i = 0; i < len; ++i) {
        const int& t = alls[i];
        for (int u : out_mp[t]) pq.push(u);
        if (mp.find(t) == mp.end() || pq.empty()) continue;
        int u = pq.top(); pq.pop();
        ans[u] += mp[t].fi, out_mp[t + mp[t].se].push_back(u);
    }
    for (int i = 1; i <= n; ++i) printf("%lld\n", ans[i]);

    return 0;
}