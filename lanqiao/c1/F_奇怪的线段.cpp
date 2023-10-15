#include <cstdio>
#include <cstring>
#include <unordered_map>
#include <vector>
#include <algorithm>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 2e5 + 10;
int n, q;
int tr[N];
unordered_map<int, vector<int>> l2r, r2l;
unordered_map<int, vector<PII>> altb, agtb;
int ans[N];

int lowbit(int x) {
    return x & -x;
}

void add(int i, int x) {
    for (; i < N; i += lowbit(i)) tr[i] += x;
}

int qry(int i) {
    int res = 0;
    for (; i > 0; i -= lowbit(i)) res += tr[i];
    return res;
}

int main() {
    scanf("%d%d", &n, &q);
    for (int i = 0; i < n; ++i) {
        int l, r;
        scanf("%d%d", &l, &r);
        l2r[l].push_back(r), r2l[r].push_back(l);
    }
    for (int i = 0; i < q; ++i) {
        int a, b;
        scanf("%d%d", &a, &b);
        if (a == b) ans[i] = 0;
        else if (a < b) altb[a].push_back({b, i});
        else agtb[a].push_back({b, i});
    }
    for (int x = 1; x <= 2e5; ++x) {
        for (const auto& r : l2r[x]) add(r, 1);
        for (const auto& [b, i] : altb[x]) ans[i] = qry(b - 1) - qry(x - 1);
        add(x, -r2l[x].size());
    }
    memset(tr, 0, sizeof(tr));
    for (int x = 2e5; x >= 1; --x) {
        for (const auto& l : r2l[x]) add(l, 1);
        for (const auto& [b, i] : agtb[x]) ans[i] = qry(x) - qry(b);
        add(x, -l2r[x].size());
    }
    for (int i = 0; i < q; ++i) printf("%d\n", ans[i]);

    return 0;
}