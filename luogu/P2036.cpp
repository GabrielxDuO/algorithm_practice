#include <iostream>

using namespace std;

const int N = 20;
int n;
int s[N], b[N];
int mn = 1e9;

void dfs(int u, int ts, int tb, bool sel) {
    if (u == n) {
        if (sel) mn = min(mn, abs(ts - tb));
        return;
    }
    dfs(u + 1, ts * s[u], tb + b[u], true);
    dfs(u + 1, ts, tb, sel);
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d%d", &s[i], &b[i]);
    dfs(0, 1, 0, false);
    printf("%d\n", mn);

    return 0;
}