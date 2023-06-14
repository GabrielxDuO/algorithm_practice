#include <cstdio>

using namespace std;

const int N = 110;
int n, m, k;
int roots[N];
bool enemy[N][N];

int find(int x) {
    return x == roots[x] ? x : (roots[x] = find(roots[x]));
}

void join(int p, int q) {
    roots[find(p)] = find(q);
}

int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i <= n; ++i) roots[i] = i;
    while (m--) {
        int a, b, rela;
        scanf("%d%d%d", &a, &b, &rela);
        if (~rela) join(a, b);
        else enemy[a][b] = enemy[b][a] = true;
    }
    while (k--) {
        int a, b;
        scanf("%d%d", &a, &b);
        int res = 0;
        if (a == b) {
            puts("OK");
            continue;
        }
        if (find(a) == find(b)) res |= 1;
        if (enemy[a][b]) res |= 2;
        if (!res) puts("OK");
        else if (res == 1) puts("No problem");
        else if (res == 3) puts("OK but...");
        else puts("No way");
    }

    return 0;
}