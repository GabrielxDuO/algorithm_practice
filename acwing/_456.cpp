#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 2010, M = 1e6 + 10;
int n, m;
int ind[N];
int h[N], w[M], e[M], ne[M], idx;
bool stopped[N];
int que[N], hh, tt = -1;
int dists[N];

void add(int a, int b, int c) {
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++, ++ind[b];
}

void top_sort() {
    for (int u = 1; u <= n + m; ++u) {
        if (!ind[u]) que[++tt] = u;
    }
    while (hh <= tt) {
        int u = que[hh++];
        for (int i = h[u]; ~i; i = ne[i]) {
            int v = e[i];
            if (--ind[v] == 0) que[++tt] = v;
        }
    }
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof(h));
    for (int i = 1; i <= m; ++i) {
        int cnt; scanf("%d", &cnt);
        int st, ed;
        memset(stopped, false, sizeof(stopped));
        // 输入当前这趟列车经过了st...ed站  且对于s=st...ed当前列车在s站停靠时表示stopped[s]=1
        // 那么对于任意a, b(a, b=st...ed, stopped[a]=1, stopped[b]=0) 必有 a的级别>b的级别(以下简称A>B)
        // A>B可以转化为A>=B+1 按照差分约束的做法可以连一条b->a权值为1的边 但是按照这种建图方式每次建出边的数量是乘法级别的
        // 最大数据最坏情况下需要建出2.5*10^8条边 不超时也会超内存 所以考虑建立中转虚拟点来优化
        for (int j = 0; j < cnt; ++j) {
            int s; scanf("%d", &s);
            if (j == 0) st = s;
            else if (j == cnt - 1) ed = s;
            stopped[s] = true;
        }
        // 对于第i=1...m趟车 建立编号为n+i的虚拟顶点 若找到关系A>=B+1 则建一条b->vr权值为0的边 一条vr->a权值为1的边
        // 这样以来需要建立边的数量就变成了加法级别的 最多会建出10^6条边
        int vr = n + i;
        for (int u = st; u <= ed; ++u) {
            if (stopped[u]) add(vr, u, 1);
            else add(u, vr, 0);
        }
    }
    // 按以上的方法建出图后本题就变成了1192题 做一次拓扑排序再做一次最长路即可
    top_sort();
    for (int u = 1; u <= n; ++u) dists[u] = 1;
    for (int i = 0; i <= tt; ++i) {
        int u = que[i];
        for (int j = h[u]; ~j; j = ne[j]) {
            int v = e[j];
            dists[v] = max(dists[v], dists[u] + w[j]);
        }
    }
    int ans = 0;
    for (int u = 1; u <= n; ++u) ans = max(ans, dists[u]);
    printf("%d\n", ans);

    return 0;
}