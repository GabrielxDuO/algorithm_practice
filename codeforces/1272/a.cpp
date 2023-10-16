#include <cstdio>
#include <cmath>
#include <algorithm>

using namespace std;

int q;
int p[5];

int dfs(int u) {
    if (u == 3) return abs(p[0] - p[1]) + abs(p[0] - p[2]) + abs(p[1] - p[2]);
    int sum = dfs(u + 1);
    ++p[u];
    sum = min(sum, dfs(u + 1));
    p[u] -= 2;
    sum = min(sum, dfs(u + 1));
    ++p[u];
    return sum;
}

int main() {
    scanf("%d", &q);
    while (q--) {
        for (int i = 0; i < 3; ++i) scanf("%d", &p[i]);
        printf("%d\n", dfs(0));
    }

    return 0;
}