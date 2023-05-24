#include <iostream>

using namespace std;

const int N = 1e6 + 10;
int m, n, k;
int roots[N];
int groups;

int find(int x) {
    return x == roots[x] ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    int rp = find(p), rq = find(q);
    if (rp != rq) {
        roots[rp] = rq;
        --groups;
    }
}

int main() {
    scanf("%d%d%d", &m, &n, &k);
    groups = m * n;
    for (int i = 1; i <= m * n; ++i) roots[i] = i;
    while (k--) {
        int a, b;
        scanf("%d%d", &a, &b);
        join(a, b);
    }
    printf("%d\n", groups);
    
    return 0;
}