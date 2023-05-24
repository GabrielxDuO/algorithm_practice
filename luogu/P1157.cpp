#include <iostream>

using namespace std;

const int N = 30;
int n, r;
int chosen[30];

void dfs(int u, int st) {
    if (n - st + 1 < r - u) return;
    if (u == r) {
        for (int i = 0; i < r; ++i) printf("%3d", chosen[i]);
        puts("");
        return;
    }
    for (int x = st; x <= n; ++x) {
        chosen[u] = x;
        dfs(u + 1, x + 1);
    }
}

int main() {
    scanf("%d%d", &n, &r);
    dfs(0, 1);

    return 0;
}