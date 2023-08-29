#include <cstdio>
#include <queue>
#include <algorithm>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;
typedef pair<int, PII> PIII;

const int N = 1e3 + 10, M = 1e4 + 10, L = 1e5 + 10;
int n, m, l;
int times[N], cnts[M], orders[L];

int main() {
    scanf("%d%d%d", &n, &m, &l);
    for (int i = 1; i <= n; ++i) scanf("%d", &times[i]);
    for (int i = 1; i <= l; ++i) scanf("%d", &orders[i]);
    priority_queue<int, vector<int>, greater<int>> brc;
    for (int i = 1; i <= m; ++i) brc.push(i);
    int t = 0;
    vector<PII> ans;
    priority_queue<PIII, vector<PIII>, greater<PIII>> pq;
    for (int i = 1; i <= l || !pq.empty(); ) {
        while (!pq.empty() && pq.top().fi <= t) {
            ans.push_back({pq.top().fi, pq.top().se.fi});
            brc.push(pq.top().se.se);
            pq.pop();
        }
        while (!brc.empty() && i <= l) {
            pq.push({times[orders[i]] + t, {i++, brc.top()}});
            ++cnts[brc.top()];
            brc.pop();
        }
        ++t;
    }
    sort(ans.begin(), ans.end());
    bool is_first = true;
    for (auto pr : ans) {
        if (is_first) is_first = false;
        else printf(" ");
        printf("%d:%d", pr.se, pr.fi);
    }
    puts("");
    is_first = true;
    for (int i = 1; i <= m; ++i) {
        if (is_first) is_first = false;
        else printf(" ");
        printf("%d", cnts[i]);
    }


    return 0;
}