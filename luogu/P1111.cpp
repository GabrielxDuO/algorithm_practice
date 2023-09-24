#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 1e3 + 10, M = 1e5 + 10;
int n, m;
struct Info {
    int u, v, t;
} infos[M];
int roots[N];
int groups;

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    p = find(p), q = find(q);
    if (p == q) return;
    roots[p] = q;
    --groups;
}


int main() {
    scanf("%d%d", &n, &m);
    groups = n;
    for (int u = 1; u <= n; ++u) roots[u] = u;
    for (int i = 0; i < m; ++i) {
        scanf("%d%d%d", &infos[i].u, &infos[i].v, &infos[i].t);
    }
    sort(infos, infos + m, [](const Info& x, const Info& y) {
        return x.t < y.t;
    });
    for (int i = 0; i < m; ++i) {
        join(infos[i].u, infos[i].v);
        if (groups == 1) {
            printf("%d\n", infos[i].t);
            return 0;
        }
    }
    puts("-1");

    return 0;
}