#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e4 + 10;
int n, m, w;
int cost[N], val[N];
int roots[N];
int f[N];

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    p = find(p), q = find(q);
    if (p == q) return;
    roots[p] = q;
    val[q] += val[p];
    cost[q] += cost[p];
}

int main() {
    scanf("%d%d%d", &n, &m, &w);
    for (int i = 1; i <= n; ++i) {
        scanf("%d%d", &cost[i], &val[i]);
        roots[i] = i;
    }
    while (m--) {
        int u, v;
        scanf("%d%d", &u, &v);
        join(u, v);
    }
    for (int i = 1; i <= n; ++i) {
        // 当roots[i]==i时 说明i是该连通块的根结点 否则跳过防止重复枚举到相同的连通块
        if (roots[i] != i) continue;
        for (int j = w; j >= cost[i]; --j) {
            f[j] = max(f[j], f[j - cost[i]] + val[i]);
        }
    }
    printf("%d\n", f[w]);

    return 0;
}