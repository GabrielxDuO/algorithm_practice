#include <cstdio>
#include <cmath>
#include <algorithm>

using namespace std;

const int N = 3e4 + 10;
int t;
int roots[N], sizes[N], dists[N];

int find(int x) {
    if (roots[x] == x) return x;
    int rrx = find(roots[x]);
    dists[x] += dists[roots[x]];
    return roots[x] = rrx;
}

void join(int p, int q) {
    int rp = find(p), rq = find(q);
    if (rp == rq) return;
    dists[rp] = sizes[rq];
    sizes[rq] += sizes[rp];
    roots[rp] = rq;
}

int main() {
    scanf("%d", &t);
    for (int i = 1; i <= N; ++i) roots[i] = i, sizes[i] = 1;
    while (t--) {
        char op;
        int i, j;
        scanf("\n%c%d%d", &op, &i, &j);
        if (op == 'M') join(i, j);
        else {
            if (find(i) != find(j)) puts("-1");
            else printf("%d\n", max(0, abs(dists[i] - dists[j]) - 1));
        }
    }

    return 0;
}