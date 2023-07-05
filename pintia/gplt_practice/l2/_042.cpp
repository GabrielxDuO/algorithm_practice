#include <cstdio>
#include <utility>
#include <vector>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int INF = 1e9, ED = 23 * 3600 + 59 * 60 + 59;
int n;
vector<PII> segs;

void merge() {
    vector<PII> vec;
    int st = -INF, ed = -INF;
    for (const PII& seg : segs) {
        int l = seg.first, r = seg.second;
        if (l > ed) {
            if (st != -INF) vec.push_back({st, ed});
            st = l;
            ed = r;
        } else ed = max(ed, r);
    }
    if (st != -INF) vec.push_back({st, ed});
    segs = vec;
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        int h1, m1, s1, h2, m2, s2;
        scanf("%d:%d:%d - %d:%d:%d", &h1, &m1, &s1, &h2, &m2, &s2);
        segs.push_back({h1 * 3600 + m1 * 60 + s1, h2 * 3600 + m2 * 60 + s2});
    }
    sort(segs.begin(), segs.end());
    merge();
    bool flag = false;
    if (segs.front().first != 0) {
        printf("00:00:00 - ");
        flag = true;
    } else if (segs.front().second == ED) return 0;
    for (int i = 0; i < segs.size(); ++i) {
        int l = segs[i].first, r = segs[i].second;
        int lh = l / 3600, lm = l / 60 % 60, ls = l % 60;
        if (i != 0 || flag) printf("%02d:%02d:%02d\n", lh, lm, ls);
        int rh = r / 3600, rm = r / 60 % 60, rs = r % 60;
        if (r == ED) break;
        printf("%02d:%02d:%02d - ", rh, rm, rs);
    }
    if (segs.back().second != ED) puts("23:59:59");


    return 0;
}