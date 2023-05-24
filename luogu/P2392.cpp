#include <iostream>
#include <algorithm>

using namespace std;

typedef pair<int, int> PII;

const int N = 30;
int s[4], a[N], n;
int mn, ans;

void dfs(int u, int l, int r) {
    if (u == n) {
        mn = min(mn, max(l, r));
        return;
    }
    dfs(u + 1, l + a[u], r);
    dfs(u + 1, l, r + a[u]);
}

int main() {
    for (int i = 0; i < 4; ++i) scanf("%d", &s[i]);
    for (int i = 0; i < 4; ++i) {
        n = s[i];
        for (int j = 0; j < n; ++j) scanf("%d", &a[j]);
        mn = 1e9;
        dfs(0, 0, 0);
        ans += mn;
    }
    printf("%d\n", ans);

    return 0;
}