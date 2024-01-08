#include <cstdio>
#include <utility>
#include <algorithm>

#define fi first
#define se second

using namespace std;

typedef pair<int, int> PII;

const int N = 1e5 + 10;
int n, len;
int L[N], S[N];
vector<PII> segs;

bool check(int t) {
    segs.clear();
    for (int i = 0; i < n; ++i) {
        if (t < S[i]) continue;
        segs.push_back({L[i] - (t - S[i]), L[i] + (t - S[i])});
    }
    if (segs.empty()) return false;
    sort(segs.begin(), segs.end());
    if (segs.front().fi > 1) return false;
    int st = segs.front().fi, ed = segs.front().se;
    for (int i = 1; i < segs.size(); ++i) {
        const int& l = segs[i].fi, & r = segs[i].se;
        if (l - 1 <= ed) ed = max(ed, r);
        else return false;
    }
    return ed >= len;
}

int main() {
    scanf("%d%d", &n, &len);
    int l = 2e9, r = 2e9;
    for (int i = 0; i < n; ++i) {
        scanf("%d%d", &L[i], &S[i]);
        l = min(l, S[i]);
    }
    while (l < r) {
        int m = l + (r - l >> 1);
        if (check(m)) r = m;
        else l = m + 1;
    }
    printf("%d\n", l);

    return 0;
}