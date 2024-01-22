#include <cstdio>
#include <iostream>
#include <algorithm>

using namespace std;

const int N = 25, M = 1e4 + 10;
int n, k;
string pat[N], str;

int _ = [] {
    ios::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    return 0;
}();

int dfs(int st) {
    if (st >= str.size()) return 0;
    int mx = 0;
    for (int i = 0; i < n; ++i) {
        size_t pos = str.find(pat[i], st);
        if (pos != st) continue;
        mx = max(mx, (int) pat[i].size() + dfs(st + pat[i].size()));
    }
    return mx;
}

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; ++i) cin >> pat[i];
    while (k--) {
        cin >> str;
        printf("%d\n", dfs(0));
    }

    return 0;
}