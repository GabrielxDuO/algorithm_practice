#include <cstdio>

using namespace std;

const int N = 210, M = N * N;
int n, m;
int roots[M];

int find(int x) {
    return roots[x] == x ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n * n; ++i) roots[i] = i;
    for (int i = 1; i <= m; ++i) {
        int x, y;
        char op;
        scanf("%d %d %c", &x, &y, &op);
        int pos = (x - 1) * n + y, npos;
        if (op == 'D') npos = x * n + y;
        else if (op == 'R') npos = (x - 1) * n + y + 1;
        if (find(pos) == find(npos)) {
            printf("%d\n", i);
            return 0;
        }
        join(pos, npos);
    }
    puts("draw");

    return 0;
}