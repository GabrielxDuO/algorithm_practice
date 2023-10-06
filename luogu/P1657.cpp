#include <cstdio>

using namespace std;

const int N = 25;
int n;
int a[N][2];
bool used[N];
int ans;

void dfs(int u) {
    if (u > n) {
        ++ans;
        return;
    }
    if (!used[a[u][0]]) {
        used[a[u][0]] = true;
        dfs(u + 1);
        used[a[u][0]] = false;
    }
    if (a[u][1] != a[u][0] && !used[a[u][1]]) {
        used[a[u][1]] = true;
        dfs(u + 1);
        used[a[u][1]] = false;
    }
}

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d%d", &a[i][0], &a[i][1]);
    dfs(1);
    printf("%d\n", ans);

    return 0;
}