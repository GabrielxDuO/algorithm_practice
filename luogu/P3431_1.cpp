#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

typedef long long LL;

const int K = 1e5 + 10;
int n, m, k;
struct Pos {
    int x, y, w;

    bool operator<(const Pos& o) const {
        return x != o.x ? x < o.x : y < o.y;
    }
} pos[K];
int alls[K];
LL tr[K];

int lowbit(int x) {
    return x & -x;
}

void modify(int i, LL x) {
    for (; i <= k; i += lowbit(i)) tr[i] = max(tr[i], x); 
}

LL query(int i) {
    LL res = 0LL;
    for (; i > 0; i -= lowbit(i)) res = max(res, tr[i]);
    return res;
}

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 1; i <= k; ++i) {
        scanf("%d%d%d", &pos[i].x, &pos[i].y, &pos[i].w);
        alls[i] = pos[i].y;
    }
    sort(pos + 1, pos + k + 1);
    sort(alls + 1, alls + k + 1);
    int len = unique(alls + 1, alls + k + 1) - (alls + 1);
    LL ans = 0LL;
    for (int i = 1; i <= k; ++i) {
        pos[i].y = lower_bound(alls + 1, alls + len + 1, pos[i].y) - alls;
        LL u = query(pos[i].y) + pos[i].w;
        ans = max(ans, u);
        modify(pos[i].y, u);
    }
    printf("%lld\n", ans);

    return 0;
}