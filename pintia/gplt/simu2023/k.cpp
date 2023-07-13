#include <cstdio>
#include <iostream>
#include <unordered_map>

using namespace std;

int _ = []() {
    ios::sync_with_stdio(false);
    cin.tie(NULL), cout.tie(NULL);
    return 0;
}();

const int N = 1e4 + 10, M = 2e5;
int n, m, idx;
unordered_map<string, int> mp;
int fa[M], cnts[M];

int conv(string s) {
    if (mp.find(s) == mp.end()) mp[s] = ++idx;
    return mp[s];
}

void modify(int u, int x) {
    u = fa[u];
    while (u) {
        cnts[u] += x;
        u = fa[u];
    }
}

int main() {
    cin >> n >> m;
    string a, b;
    int na, nb;
    idx = n;
    while (m--) {
        cin >> a >> b;
        if (a[0] >= '0' && a[0] <= '9') na = stoi(a);
        else na = conv(a);
        nb = conv(b);
        fa[na] = nb;
    }
    for (int u = 1; u <= n; ++u) modify(u, 1);
    char op;
    while ((cin >> op) && op != 'E') {
        string y;
        if (op == 'T') {
            int x;
            cin >> x >> y;
            modify(x, -1);
            fa[x] = conv(y);
            modify(x, 1);
        } else {
            cin >> y;
            cout << cnts[conv(y)] << '\n';
        }
    }

    return 0;
}