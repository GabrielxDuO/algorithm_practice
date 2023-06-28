#include <cstdio>
#include <queue>

using namespace std;

const int N = 35;
int n, idx;
int tr[N];

void dfs(int u) {
    if (u > n) return;
    dfs(u << 1);
    dfs(u << 1 | 1);
    scanf("%d", &tr[u]);
}

int main() {
    scanf("%d", &n);
    dfs(1);
    for (int i = 1; i <= n; ++i) {
        printf("%d", tr[i]);
        printf(i == n ? "\n" : " ");
    }

    return 0;
}